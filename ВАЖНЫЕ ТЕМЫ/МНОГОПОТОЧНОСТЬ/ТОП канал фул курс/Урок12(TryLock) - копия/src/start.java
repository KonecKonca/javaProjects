import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class start {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        new Thread1().start();
        new Thread2().start();
    }

    static class Thread1 extends Thread{
        @Override
        public void run(){
            lock.lock();
            System.out.println(getName() + " start working");
            try{
                sleep(50);
            }catch(Exception ex){}
            System.out.println(getName() + " stop working");
            lock.unlock();
            System.out.println(getName() + " lock is released");
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run(){
            System.out.println(getName() + " begim working");
            while(true){
                try {
                    sleep(10);
                }catch(Exception ex){}
                if(lock.tryLock()){
                    System.out.println(getName() + " working");
                    break;
                }
                else{
                    System.out.println(getName() + " waiting");
                }
            }
        }
    }
}
