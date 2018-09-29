import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class start{
    public static void main(String[] args) throws InterruptedException {
        X x = new X();

        Thread thread1 = new Thread(() ->{
            for(int i = 0; i < 10000; i++) {
                x.increment();
            }
            });
        Thread thread2 = new Thread(() ->{
            for(int i = 0; i < 10000; i++) {
                x.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(x.getX());
    }
}

class X{
    private int x;

    public int getX() {
        return x;
    }
    public synchronized void increment(){
        x++;
    }
}