import sun.awt.windows.ThemeReader;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainClass {
    public static void main(String[] args){
        Book book = new Book("XxXXXxX", 5);
        for(int i = 0; i<7; i++){
            new Thread(() -> {
                try {
                    Thread.sleep(Math.round(Math.random() * 700));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                book.change();
                book.use();
            }).start();
        }

    }
}

class Book{
    private String name;
    private int nomber;

    public Book(String name, int nomber) {
        this.name = name;
        this.nomber = nomber;
    }
    public String getName() {
        return name;
    }
    public int getNomber() {
        return nomber;
    }

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public void change(){
        writeLock.lock();
        nomber++;
        writeLock.unlock();
    }
    public void use(){
        readLock.lock();
        System.out.println("Nomber is: " + nomber);
        System.out.println("Nomber is: " + nomber);
        System.out.println("---------------------------------");
        readLock.unlock();
    }
}