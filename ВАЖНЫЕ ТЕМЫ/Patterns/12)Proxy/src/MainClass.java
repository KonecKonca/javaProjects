import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static void main(String[] args){
        Car car1 = new Reno();
        car1.drive();

        car1 = new RenoProxy();
        car1.drive();
    }
}

interface Car{
    void drive();
}

class RenoProxy implements Car{
    private Car car = new Reno();

    @Override
    public void drive() {
        System.out.println("It Is a Proxy");
        car.drive();
    }
}

class Reno implements Car{
    @Override
    public void drive() {
        System.out.println("Drive on Reno");
    }
}
