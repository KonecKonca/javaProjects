import javax.swing.*;
import java.awt.*;

public class start{
    public static void main(String[] args) {
        Graphics graphics = new Graphics();
    }
}

class Graphics extends JFrame{
    public Graphics(){
        super("XxXXxXXx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 80);
        setVisible(true);
        setLayout(new FlowLayout());

        Thread[] threads = new Thread[3];
        MyTread[] myTreads = new MyTread[3];
        myTreads[0] = new MyTread("Первый");
        myTreads[1] = new MyTread("Второй");
        myTreads[2] = new MyTread("Третий");
        for(int i = 0; i < 3; i++){
            threads[i] = new Thread(myTreads[i]);
        }

        JButton stopAll = new JButton("Стоп");
        stopAll.addActionListener(e -> {
            System.out.println("!!!!!!!!!!");
            for(int i = 0; i < 3; i++){
                try {
                    threads[i].stop();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(stopAll);

        JButton runAll = new JButton("Старт");
        runAll.addActionListener(e -> {
            System.out.println("!!!!!!!!!!");
            for(int i = 0; i < 3; i++){
                threads[i].start();
            }
        });
        add(runAll);


    }
}

class MyTread implements Runnable{
    private String name = "";
    public  MyTread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("-/-/ " + name + " -/-/   ");
        }
    }
}