package base.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeCounterAspect {

    public Object showTime(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) { /* NOP */}

        long endTime = System.currentTimeMillis();
        System.out.println("aspect: Method worked: " + (endTime - startTime));

        return result;
    }

}
