import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        CarF carF1 = new CarF(150, "GREEN", 4);
        CarF carF2 = new CarF(200, "red", 2);
        CarF carF3 = new CarF(250, "black", 4);
        List<CarF> cars = new ArrayList<>(Arrays.asList(carF1, carF2, carF3));

        cars = new SpeedFilter().filter(cars);
        System.out.println(cars);
    }
}

interface CarFilter{
    List<CarF> filter(List<CarF> cars);
}
class SpeedFilter implements CarFilter{
    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = new ArrayList<>();
        for (CarF carF : cars){
            if(carF.getMaxSpeed() > 160){
                list.add(carF);
            }
        }
        return list;
    }
}

class CarF{
    private int maxSpeed;
    private String color;
    private int kolDors;
    public CarF(int maxSpeed, String color, int kolDors) {
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.kolDors = kolDors;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public int getKolDors() {
        return kolDors;
    }

    @Override
    public String toString() {
        return "CarF{" +
                "maxSpeed=" + maxSpeed +
                ", color='" + color + '\'' +
                ", kolDors=" + kolDors +
                '}';
    }
}
