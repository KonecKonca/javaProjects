/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.*;

public class start {
    public static void main(String[] args) {
        start s = new start();
        s.metod("535");

        Car car = new Car();
        car.show("any text");
    }

    <T> T metod(T type){
        System.out.println(type);
        return type;
    }
}

class Car <T>{
    private T x;
    public void show(T z){
        x = z;
        System.out.println(x);
    }
}