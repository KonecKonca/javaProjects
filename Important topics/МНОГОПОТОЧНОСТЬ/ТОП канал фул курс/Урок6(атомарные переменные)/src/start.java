import java.util.concurrent.atomic.AtomicInteger;

// volatile --- переменные не кэштруются и хранятся в основной памяти
public class start{
    static AtomicInteger atomicInteger = new AtomicInteger(0); // с атомарной обёрткой всегда будет один и тот же результат
    //static volatile int i = 0// не атомарная переменная(volatile канает онли для атомарных оперпаций), поэтому результаты будут разными
    // volatile просто предоставляет доступ к одной и той же переменной(отмена кэширования)

    public static void main(String[] args) throws Exception{
        for(int i = 0; i < 20; i++){
            MyThread myThread = new MyThread();
            for(int j = 0; j < 10000; j++){
                new Thread(myThread).start();
            }
            Thread.sleep(100); // без слипа тоже будут выводится разные значения
            System.out.println(atomicInteger.get());  // с неатомарной будет разный вывод(иногда изменения из разных потоков будут расщкплять друг друга)
        }
    }

    static class MyThread implements Runnable{
        @Override
        public void run(){
            atomicInteger.incrementAndGet();

            /*
            для не атомарных что-то типо того (i++)
            ////////////////////////////////////

            int k = i + 1; i=4 k=5

            int k = i + 1; i=4 k=5  | одно изменение влезло между частями другого (а переменная используется одна)
            i = k;                  | поэтому переменная не успевает обновиться и действие проходит в холостую
            i = k;

            i = k;   i=5
             */
        }
    }
}
