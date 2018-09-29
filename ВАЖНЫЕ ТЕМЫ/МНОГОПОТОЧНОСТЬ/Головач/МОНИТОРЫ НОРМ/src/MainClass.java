import sun.awt.windows.ThemeReader;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        ForSyncron forSyncron = new ForSyncron();
        forSyncron.setI(0);

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.setForSyncron(forSyncron);
        threadB.setForSyncron(forSyncron);

        threadA.start();
        Thread.sleep(10);
        threadB.start();
    }
}

class ForSyncron{
    private int i;

    public void setI(int i) {
        this.i = i;
    }
    public int getI() {
        return i;
    }
}

class ThreadA extends Thread{
    private ForSyncron forSyncron;
    public void setForSyncron(ForSyncron forSyncron) {
        this.forSyncron = forSyncron;
    }

    @Override
    public void run() {
        try {
            synchronized (forSyncron){
                System.out.println("1.Получили заказ\n");
                forSyncron.wait();

                System.out.println("3.Обдумали план действий\n");
                forSyncron.notify();
                forSyncron.wait();

                System.out.println("5.Проконтролировали корректное выполнеие\n");
                forSyncron.notify();
                forSyncron.wait();

                System.out.println("7.Получили деньги\n");
                forSyncron.notify();
                forSyncron.wait();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread{
    private ForSyncron forSyncron;
    public void setForSyncron(ForSyncron forSyncron) {
        this.forSyncron = forSyncron;
    }


    @Override
    public void run() {
        synchronized (forSyncron){
            try {
                System.out.println("2.Состававили ТЗ\n");
                forSyncron.notify();
                forSyncron.wait();

                System.out.println("4.Наняли работяг\n");
                forSyncron.notify();
                forSyncron.wait();

                System.out.println("6.Сдали работу\n");
                forSyncron.notify();
                forSyncron.wait();

                System.out.println("8.Пошли отмечать\n");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

//ебнуть связующий объект, + на нем потестить вызов синхрон методов