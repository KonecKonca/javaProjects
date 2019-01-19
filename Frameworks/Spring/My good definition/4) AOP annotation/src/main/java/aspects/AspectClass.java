package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("advices")
@Aspect public class AspectClass {

    @Pointcut("execution(* *(..)) && within(test.entities.*) && @annotation(aspects.WorkAspects)")  //"execution(* test.entities.Plumber.work(..))
    public void nameOfSrez(){}  // это имя среза

    @Before("execution (* test.entities.*.*(..))")
    public void beforeVisiting(){
        System.out.println("\t---Hello aspect");
    }

    @After("nameOfSrez()")
    public void afterVisiting(){
        System.out.println("\t---GoodBye aspect");
    }

    @Around("nameOfSrez()")
    public void totalTime(ProceedingJoinPoint joinPoint){
        System.out.println("\t---Time is starting");
        long time1 = System.currentTimeMillis();

        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        long time2 = System.currentTimeMillis();
        System.out.println("\t---Время выполнения: " + (time2-time1));
    }

}
