
public class start{
    public static void main(String[] args) throws Exception{

        MyRunable myRunable1 = new MyRunable();
        Thread thread1 = new Thread(myRunable1);
        // от 0 до 10 (по дефолту идёт 5)
        thread1.setPriority(Thread.MAX_PRIORITY);  // тупо константа равная 10
        Thread.yield(); // что-то типо как сказать джаве пока запусти другой поток(имеется в виду пожертвовать своей оперативкой для другого потока)
        // Все потоки одновременно выполняется но текущему отдаётся предпочтение

        // разумеется что это нихрена не гарантирует
        thread1.start();
        thread1.join();// ПОКА ПОТОК ПОЛНОСЬТЮ НЕ ВЫПОЛНЕТСЯ ДРУГОЙ НЕ БУДЕТ ВЫПОЛНЯТЬСЯ
        // В отличии от sleep и yield юзается не по ссылке на другие потоки т.е нельзя для текущего

        MyRunable myRunable2 = new MyRunable();
        Thread thread2 = new Thread(myRunable2);
        thread2.start();

        for(int i = 0; i < 10; i++){
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
        for(int i = 0; i < 10; i++){
            System.out.println("My thread  " + Thread.currentThread().getName() + " номер " + i);
            try {
                Thread.sleep(1000);
            }
            catch (Exception ex){ }
        }
    }
}
