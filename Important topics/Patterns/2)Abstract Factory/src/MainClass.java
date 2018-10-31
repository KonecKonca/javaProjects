import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        Factory<Tank> tankFactory = new AbstractFactory().createFactory("TankFactory");
        Factory<Car> carFactory = new AbstractFactory().createFactory("CarFactory");

        carFactory.create("Toyota").ride();
        carFactory.create("Mazda").ride();
        carFactory.create("Mersedes").ride();

        tankFactory.create("Armata").drive();
        tankFactory.create("Abrams").drive();
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


interface Tank{
    void drive();
}
class Armata implements Tank{
    @Override
    public void drive() {
        System.out.println("Armata");
    }
}
class Abrams implements Tank{
    @Override
    public void drive() {
        System.out.println("Abrams");
    }
}

