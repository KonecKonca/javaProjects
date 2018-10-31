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
//        Queue<String> queue = new PriorityQueue<>();//  У нас нет гарантии, что сначала элемент добавится(может пытаться достать из пустой лочередм)
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();  // блокирующая очередь(в ней осуществлена блокировка(нельзя достать элемент, пока не положили))

        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                queue.add("any string");
            }
        }.start();

    }
}
