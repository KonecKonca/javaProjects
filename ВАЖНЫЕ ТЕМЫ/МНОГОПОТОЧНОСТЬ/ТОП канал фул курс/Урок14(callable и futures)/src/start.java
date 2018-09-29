import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//так же как и вэит и модифай(у синхронов)
// у локов есть кондишэны

public class start {
    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = new MyCallable();  // Альтернатива на основе runuble
        FutureTask futureTask = new FutureTask(callable); // также как и с импелментациее ранэйбла только другие классы
        new Thread(futureTask).start();
        System.out.println(futureTask.get());  // Аналог join(ждём завершения результата)
    }

    static class MyCallable implements Callable<Integer>{ // можно ещё вернуть результат
        @Override
        public Integer call() throws Exception{
            int i = 0;
            for(int j = 0; j < 10; j++, i++){
                Thread.sleep(30);
            }
            return i;
        }
    }
}
