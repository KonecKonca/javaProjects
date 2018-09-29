import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class start{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Стройка началась!!!!!!!!!! " + Thread.currentThread().getName());

        Thread builder1 = new Thread(() -> {
            for(int i = 0; i < 3; i++){
                System.out.println("Строим " + Thread.currentThread().getName() + "\n");
            }
        });
        Thread builder2 = new Thread(() -> {
            for(int i = 0; i < 3; i++){
                System.out.println("Строим " + Thread.currentThread().getName() + "\n");
            }
        });
        Thread builder3 = new Thread(() -> {
            for(int i = 0; i < 3; i++){
                System.out.println("Строим " + Thread.currentThread().getName() + "\n");
            }
        });

        Thread painter1 = new Thread(new Painter().setBuilders(builder1, builder2, builder3));
        Thread painter2 = new Thread(new Painter().setBuilders(builder1, builder2, builder3));

        Thread result = new Thread(() ->{
            try {
                painter1.join();
                painter2.join();
            }
            catch (InterruptedException e){}
            System.out.println("Доделыаем мелочи)) " + Thread.currentThread().getName() + "\n");
        });

        Thread[] threads = new Thread[6];
        threads[0] = builder1;
        threads[1] = builder2;
        threads[2] = builder3;
        threads[3] = painter1;
        threads[4] = painter2;
        threads[5] = result;
        for(int i = 0 ; i < threads.length; i++){
            threads[i].start();
        }
        result.join();
        System.out.println("ВСЁ ГОТОВО " + Thread.currentThread().getName() + " \n");
    }
}

class Painter implements Runnable{
    private Thread builder1;
    private Thread builder2;
    private Thread builder3;

    public Painter setBuilders(Thread builder1, Thread builder2, Thread builder3){
        this.builder1 = builder1;
        this.builder2 = builder2;
        this.builder3 = builder3;
        return this;
    }

    @Override
    public void run() {
        try {
            builder1.join();
            builder2.join();
            builder3.join();
        }
        catch (InterruptedException e){ }
        for(int i = 0; i < 2; i++){
            System.out.println("Красим " + Thread.currentThread().getName() + "\n");
        }
    }
}