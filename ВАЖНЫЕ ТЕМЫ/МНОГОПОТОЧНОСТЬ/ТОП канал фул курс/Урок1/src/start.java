

// У каждого потока свой стек
// Нет никакой гарантии касаемо порядка выполнения !!!
public class start{
    public static void main(String[] args){

        MyThread myThread = new MyThread();
        myThread.start(); // Поток запускатеся только привызове старт!!!!!!!
                            // Также нельзя вызвать поток второй раз!!!
        MyRunable myRunable = new MyRunable();
        Thread thread2 = new Thread(myRunable);
        thread2.start();

        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread extends Thread{
    @Override
    public void run(){ // то что должно выполняться (НО ЗАПУСКАТЬ ОБЯЗАТЕЛЬНО СТАРТ!!!!)
        for(int i = 0; i < 100; i++){
            System.out.println("My thread  " + Thread.currentThread().getName() + " номер " + i);
            try {
                Thread.sleep(1000);
            }
            catch (Exception ex){ }
        }
    }
}

class MyRunable implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println("My thread  " + Thread.currentThread().getName() + " номер " + i);
            try {
                Thread.sleep(1000);
            }
            catch (Exception ex){ }
        }
    }
}
