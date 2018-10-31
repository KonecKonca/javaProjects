import org.w3c.dom.NameList;
import sun.util.cldr.CLDRLocaleProviderAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Мы не можем начать следующую работу, пока не закончим предидущую
public class start {
    public static void main(String[] args) throws Exception {
        Phaser phaser = new Phaser(2); // 2 - вместо регистрации фазеров(сразу указываем сколько фазеров)
        new washer(phaser);
        new washer(phaser);  // 2 чувака (1 моет, другой полирует(отработать должны оба))
        // и оба сначала должнв помвть первую машину, а потом уже браться за вторую
    }

    static class washer extends Thread{
        Phaser phaser;

        public washer(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            for(int i = 0; i < 4; i++){
                System.out.println(getName() + " washing car");
                phaser.arriveAndAwaitAdvance(); // ждём пока все потоки завершат текущий этап
            }  // Пока оба потока не вызовут этот метод, мы не можем идти дальше
        }
    }
}
