package entity.aop;

import java.util.concurrent.TimeUnit;

public class TimeTestClass {

    public void underAopAround() {
        try {
            System.out.println("aop: TimeTestClass");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {/* NOP */}
    }

}
