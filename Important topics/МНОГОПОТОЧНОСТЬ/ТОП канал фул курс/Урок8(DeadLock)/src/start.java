import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Статические синхронизированные методы лочат класс
// DeadLoack -- состояние зависания прогграммы из-за блокировки synchronized методов
public class start {
    public static void main(String[] args) throws Exception {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        myThread1.resourceA = resourceA;
        myThread2.resourceB = resourceB;

        thread1.start();
        thread2.start();
    }
}

class MyThread1 implements Runnable{
    ResourceA resourceA;

    @Override
    public void run(){
        System.out.println(resourceA.getI());
    }
}

class MyThread2 implements Runnable{
    ResourceB resourceB;

    @Override
    public void run(){
        System.out.println(resourceB.getI());
    }
}

class ResourceA{
    ResourceB resourceB;
    public synchronized int getI(){
        return resourceB.returnI();
    }
    public synchronized int returnI(){
        return 1;
    }
}

class ResourceB{
    ResourceA resourceA;
    public synchronized int getI(){
        return resourceA.returnI();
    }
    public synchronized int returnI(){
        return 2;
    }
}