import org.w3c.dom.NameList;
import sun.util.cldr.CLDRLocaleProviderAdapter;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class start {
    public static void main(String[] args) throws Exception {
        System.out.println(Math.random());  // нельзя юзать в многопоточных приложениях
        System.out.println(ThreadLocalRandom.current().nextInt());  // Нужно юзать это вариацию в многопоточных приложениях

        //Thread.sleep(1_000_000_000);  // до дефолту писать нужно в мс (если время в днях, то пздц)
        System.out.println(TimeUnit.DAYS.toMillis(14));
        //Thread.sleep(TimeUnit.DAYS.toMillis(14));  // прога заснёт на 14 дней))))
    }
}
