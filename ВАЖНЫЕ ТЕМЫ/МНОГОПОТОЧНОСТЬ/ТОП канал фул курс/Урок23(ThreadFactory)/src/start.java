import org.w3c.dom.NameList;
import sun.util.cldr.CLDRLocaleProviderAdapter;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Удобно если нужно одинаковые св-ва задать сразу нескольким потокам
public class start {
    public static void main(String[] args) throws Exception {

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };

        threadFactory.newThread(new MyRun()).start();
    }

    static class MyRun implements Runnable{
        @Override
        public void run(){
            System.out.println(1);
        }
    }
}
