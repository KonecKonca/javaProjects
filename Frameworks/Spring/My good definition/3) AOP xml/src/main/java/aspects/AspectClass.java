package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AspectClass {

    public void beforeVisiting(){
        System.out.println("\t---Hello aspect");
    }

    public void afterVisiting(){
        System.out.println("\t---GoodBye aspect");
    }

    public void someTroubles(){
        System.out.println("\t---Any problems aspect");
    }

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
