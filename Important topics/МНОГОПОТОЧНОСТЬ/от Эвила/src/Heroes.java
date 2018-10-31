import java.util.Random;

/**
 * Created by Андрей on 03.02.2018.
 */
public class Heroes implements Runnable {
    String heroName;
    int time;
    Random random = new Random();

    public Heroes(String x){
        heroName = x;
        time = random.nextInt(10000);
    }

    @Override
    public void run() {
        try {
            System.out.println(heroName + " проспал " + time + " мс");
            Thread.sleep(time); // ждать time времени
            System.out.println(heroName + " проснулся");
        }
        catch (Exception ex){}
    }
}
