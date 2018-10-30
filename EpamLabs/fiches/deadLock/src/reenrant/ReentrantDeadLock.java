package reenrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantDeadLock {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args){
        Deadlock1 deadlock1 = new Deadlock1();
        Deadlock2 deadlock2 = new Deadlock2();

        deadlock1.setDeadlock(deadlock2);
        deadlock2.setDeadlock(deadlock1);

        new  Thread(deadlock1).start();
        new  Thread(deadlock2).start();


//        new Thread(() -> lock.lock()).start();
//        new Thread(() -> lock.lock()).start();

    }
}

class Deadlock1 implements Runnable{
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Deadlock2 deadlock;
    public void setDeadlock(Deadlock2 deadlock) {
        this.deadlock = deadlock;
    }

    @Override
    public void run() {

        try {
            reentrantLock.lock();
            deadlock.getReentrantLock().lock();

            System.out.println("task1");
            reentrantLock.wait();
            reentrantLock.notify();

            System.out.println("task3");
            reentrantLock.wait();
            reentrantLock.notify();

            System.out.println("task5");
            reentrantLock.wait();
            reentrantLock.notify();

            deadlock.getReentrantLock().unlock();
            reentrantLock.unlock();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public ReentrantLock getReentrantLock() {
        return reentrantLock;
    }

}

class Deadlock2 implements Runnable{
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Deadlock1 deadlock;
    public void setDeadlock(Deadlock1 deadlock) {
        this.deadlock = deadlock;
    }

    @Override
    public void run() {

        try {
            deadlock.getReentrantLock().lock();
            reentrantLock.lock();

            reentrantLock.wait();
            System.out.println("task2");
            reentrantLock.notify();

            reentrantLock.wait();
            System.out.println("task4");
            reentrantLock.notify();

            reentrantLock.wait();
            System.out.println("task6");
            reentrantLock.notify();

            reentrantLock.unlock();
            deadlock.getReentrantLock().unlock();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public ReentrantLock getReentrantLock() {
        return reentrantLock;
    }

}
