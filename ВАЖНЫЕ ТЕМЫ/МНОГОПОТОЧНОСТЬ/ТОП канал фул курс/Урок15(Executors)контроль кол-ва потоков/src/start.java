import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Контроль работы с потоками(что-то типо повторного использования потоков)
// например у нас есть 10 потоков(из них 1 уже отработал) при создании нового мы берём уже отработавший старый
public class start {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);  // в скобках кол-во потоков
        executorService.submit(new MyRunable());
        System.out.println(executorService.submit(new MyCallable()).get());
        executorService.shutdown();  // ждёт завершения всех потоков (shutdownNow - не ждёт завершения), без этого прога не завершится
    }

    static class MyRunable implements Runnable{
        @Override
        public void run(){
            System.out.println(1);
        }
    }

    static class MyCallable implements Callable<String>{
        @Override
        public String call(){
            return "2";
        }
    }
}
