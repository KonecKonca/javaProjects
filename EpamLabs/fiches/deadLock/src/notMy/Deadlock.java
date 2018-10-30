package notMy;

import java.util.concurrent.locks.ReentrantLock;

class Deadlock {
    private static final ReentrantLock l1 = new ReentrantLock();

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println("A Trying to lock...");
            l1.lock();
            System.out.println("A Locked...");

            try {
                Thread t1 = new Thread(() -> {
                    System.out.println("B Trying to lock...");
                    l1.lock();
                    System.out.println("B Must not print");
                    try {
                    } finally {
                        System.out.println("B Trying to unlock...");
                        l1.unlock();
                        System.out.println("B Unlocked...");
                    }
                });
                t1.start();

                // comment to resolve deadLock
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } finally {
                System.out.println("A Trying to unlock...");
                l1.unlock();
                System.out.println("A Unlocked...");
            }

        });

        t.start();
    }

}



