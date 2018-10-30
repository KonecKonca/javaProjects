package synchron;

public class SynchronisedDeadLock {
    public static void main(String[] args) {

        DeadlockS1 deadlock1 = new DeadlockS1();
        DeadlockS2 deadlock2 = new DeadlockS2();

        deadlock1.setDeadlock(deadlock2);
        deadlock2.setDeadlock(deadlock1);

        new  Thread(deadlock1).start();
        new  Thread(deadlock2).start();

    }

}

class DeadlockS1 implements Runnable{
    private DeadlockS2 deadlock;
    public void setDeadlock(DeadlockS2 deadlock) {
        this.deadlock = deadlock;
    }

    @Override
    public void run() {

        try {
            synchronized (deadlock){
                synchronized (this){

                    System.out.println("task1");
                    wait();
                    notify();

                    System.out.println("task3");
                    wait();
                    notify();

                    System.out.println("task5");
                    wait();
                    notify();

                }
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

class DeadlockS2 implements Runnable{
    private DeadlockS1 deadlock;
    public void setDeadlock(DeadlockS1 deadlock) {
        this.deadlock = deadlock;
    }

    @Override
    public void run() {

        try {
            synchronized (deadlock){
                synchronized (this){

                    wait();
                    System.out.println("task2");
                    notify();

                    wait();
                    System.out.println("task4");
                    notify();

                    wait();
                    System.out.println("task6");
                    notify();

                }
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }


}
