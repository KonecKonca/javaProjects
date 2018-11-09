package annologger;

import java.io.PrintStream;
import java.lang.reflect.*;

public class LoggerFactory
{
    public static Object CreateLogObject(Object targetObject)
    {
        return createLogObject(targetObject, System.out);
    }

    public static Object createLogObject(Object targetObject, PrintStream outputStream)
    {
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), new LoggerInvokationHandler(targetObject, outputStream));
    }

    private static class LoggerInvokationHandler implements InvocationHandler
    {
        private Object targetObject = null;
        private ILoggingPolicy loggingPolicy = null;
        private PrintStream outputStream = null;

        public LoggerInvokationHandler(Object targetObject, PrintStream outputStream)
        {
            this.targetObject = targetObject;
            this.outputStream = outputStream;
            defineCustomAnnotations(targetObject);
        }

        private void defineCustomAnnotations(Object targetObject) {
            LoggingPolicyAnnotation policy = (LoggingPolicyAnnotation) targetObject.getClass().getAnnotation(LoggingPolicyAnnotation.class);
            if(policy == null)
            {
                this.loggingPolicy = new DefaultLoggingPolicy();

            }
            else
            {
                this.loggingPolicy = (ILoggingPolicy) сreateInstanse(policy.loggingPolicy());
            }
        }

        private Object сreateInstanse(Class type)
        {
            try {
                Constructor defaultConstructor = type.getConstructor(new Class[]{});
                return defaultConstructor.newInstance(new Object[]{});
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            //Here I want to retain metadata for the method of the real object
            //rather than for a method from interface which proxy implements.
            Method realMethod = targetObject.getClass().getMethod(method.getName(), (Class[])method.getGenericParameterTypes());
            if(realMethod == null)
            {
                realMethod = method;
            }
            LoggingAnnotation annotation = realMethod.getAnnotation(LoggingAnnotation.class);
            if(annotation != null)
            {
                LoggingContext loggingContext = new LoggingContext(realMethod, args, this.outputStream);
                this.loggingPolicy.onBeforeInvoke(annotation.logLevel(), loggingContext);
                Object returnValue = null;
                try
                {
                    returnValue = method.invoke(targetObject, args);
                }
                //Here and below I use getCause() to obtain real exception that has been thrown
                //during method invokation. This exception is the cause of InvocationTargetException , cause I use reflection.
                catch (InvocationTargetException e)
                {
                    loggingPolicy.onFailure(annotation.logLevel(), loggingContext, e.getCause());
                    throw e.getCause();
                }
                this.loggingPolicy.onAfterInvoke(annotation.logLevel(), loggingContext, returnValue);
            }
            try
            {
                return method.invoke(targetObject, args);
            }
            catch(InvocationTargetException e)
            {
                throw e.getCause();
            }
        }
    }
}