import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Mazda", "Toyota", "Mersedes"));

        CarFactory carFactory = new CarFactory();
        Car[] cars = new Car[7];


        for(int i = 0; i < 7; i++){
            int nomber = ((int)(Math.random()*1000))%3;
            cars[i] = carFactory.createCar(list.get(nomber));
        }

        for(int i = 0; i < cars.length; i++){
            cars[i].ride();
            System.out.println("\n--------------------\n");
        }
    }
}

interface Car{
    void ride();
}

class Toyota implements Car{
    @Override
    public void ride() {
        System.out.println("Toyota");
    }
}

class Mazda implements Car{
    @Override
    public void ride() {
        System.out.println("Mazda");
    }
}


class Mersedes implements Car{
    @Override
    public void ride() {
        System.out.println("Mersedes");
    }
}

class CarFactory{
    public Car createCar(String str){
        switch (str){
            case ("Toyota") : return new Toyota();
            case ("Mazda") : return new Mazda();
            case ("Mersedes") : return new Mersedes();
            default: return null;
        }
    }
}
