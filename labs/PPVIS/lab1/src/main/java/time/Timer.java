package time;

import lombok.Setter;

import javax.swing.*;

public class Timer {
    private volatile double[] time;
    public double getTime(){
        return time[0];
    }
    private volatile boolean isEnd = false;

    @Setter
    private JLabel label;

    public Timer() {
    }

    public void start(){
        time = new double[1];
        time[0] = 0.001;

        new Thread(() ->{
            double start = System.currentTimeMillis();
            while (!isEnd){
                time[0] = System.currentTimeMillis() - start + 1;
                label.setText("TIME:    " + time[0] / 1000 + "                             ");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void end(){
        isEnd = true;
    }
}
