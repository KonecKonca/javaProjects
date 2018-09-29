import sun.awt.windows.ThemeReader;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true){
                System.out.println("Any text!!!!!!!!!!!!!");
                try {
                    Thread.sleep(1000);
                    if(Thread.interrupted()){
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();

        Thread.sleep(3000);
        thread.interrupt();

        while (true){
            System.out.println("XXXXXXXXXXXXXXXXX");
            Thread.sleep(1000);
        }
    }
}
