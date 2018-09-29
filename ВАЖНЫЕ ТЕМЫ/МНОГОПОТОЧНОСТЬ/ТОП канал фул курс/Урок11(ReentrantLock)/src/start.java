import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class start {
    public static void main(String[] args) throws Exception {
        Resource resource = new Resource();
        resource.dannie = 10;
        resource.dopDannie = 10;

        MyThread thread1 = new MyThread();
        thread1.setName("one");
        MyThread thread2 = new MyThread();
        thread1.resource = resource;
        thread2.resource = resource;
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(resource.dannie);
        System.out.println(resource.dopDannie);
    }

    static class MyThread extends Thread{
        Resource resource;

        @Override
        public void run(){
            resource.chanheI();
        }
    }
}

class Resource{
    int dannie;
    int dopDannie;

    Lock lock = new ReentrantLock();  // КАк и синхронизация (НО ПИЗЖЕ МОЖНО ЛОЧИТЬ СРАЗУ НЕСКОЛЬКО МЕТОДОВ)

    void chanheI() {
        lock.lock();
        for (int i = 0; i < 20; i++) {
            int help = this.dannie;
            if(Thread.currentThread().getName().equals("one")){
                Thread.yield();
            }
            help++;
            this.dannie = help;
        }
        chanheJ();
    }

    void chanheJ() {
        for (int i = 0; i < 20; i++) {
            int help = this.dopDannie;
            if(Thread.currentThread().getName().equals("one")){
                Thread.yield();
            }
            help++;
            this.dopDannie = help;
        }
        lock.unlock();
    }
}