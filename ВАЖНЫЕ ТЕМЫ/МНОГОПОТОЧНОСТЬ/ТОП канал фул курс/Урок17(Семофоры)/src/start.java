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

// Люди приходят поесть в ресторан (Люди - потоки) (Столики - ресурсы)
public class start {
    public static void main(String[] args) throws Exception {
        Semaphore table = new Semaphore(2); // по примеру 2 столика

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();

        person1.table = table;
        person2.table = table;
        person3.table = table;
        person4.table = table;
        person5.table = table;
        person6.table = table;

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
    }
}

class Person extends Thread{
    Semaphore table;

    @Override
    public void run() {
        System.out.println(this.getName() + " Waiting for table");
        try {
            table.acquire();  // запрос столика
            System.out.println(this.getName() + " eat at the table");
            this.sleep(1000);
            System.out.println(this.getName() + " release table(OSVOBOJDEN)");
            table.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}