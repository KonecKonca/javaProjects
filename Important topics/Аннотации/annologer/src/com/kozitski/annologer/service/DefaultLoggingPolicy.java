package com.kozitski.annologer.service;

public class DefaultLoggingPolicy implements ILoggingPolicy {
    public void onBeforeInvoke(LogLevel level, LoggingContext context) {
        if(level == LogLevel.Low)
        {
            context.getOutputStream().println(String.format("Method %s was invoked", context.getMethod().getName()));
        }
        else
        {
            StringBuilder argsString = new StringBuilder();
            for(Object arg: context.getArguments())
            {
                argsString.append(arg.toString() + ',');
            }
            argsString.setLength(argsString.length() - 1);
            context.getOutputStream().println(String.format("Method %s was invoked with parameters : %s", context.getMethod().getName(), argsString.toString()));
        }

    }

    public void onAfterInvoke(LogLevel level, LoggingContext context, Object returnValue) {
        if(level == LogLevel.Low)
        {
            context.getOutputStream().println(String.format("Method %s finished ", context.getMethod().getName()));
        }
        else
        {
            context.getOutputStream().println(String.format("Method %s finished with value : %s", context.getMethod().getName(), returnValue.toString()));
        }
    }

    public void onFailure(LogLevel level, LoggingContext context, Throwable exception) {
        context.getOutputStream().println(String.format("Exception '%s' was thrown", exception.toString()));
    }

}
