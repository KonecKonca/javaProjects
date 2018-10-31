import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        ICar car = new ToyotaCar(new CarBridge());
        car.drive();
        car.bridgeMethod();

        System.out.println("\n------------------------\n");

        ITrack track = new ToyotaTrack(new TrackBridge());
        track.drive();
        track.bridgeMethod();
    }
}

abstract class ICar{
    private IBridge iBridge;
    public void bridgeMethod(){
        iBridge.bridgeMethod();
    }
    public ICar(IBridge iBridge) {
        this.iBridge = iBridge;
    }
    public abstract void drive();
}
abstract class ITrack{
    private IBridge iBridge;
    public void bridgeMethod(){
        iBridge.bridgeMethod();
    }
    public ITrack(IBridge iBridge) {
        this.iBridge = iBridge;
    }
    public abstract void drive();
}

interface IBridge{
    void bridgeMethod();
}
class CarBridge implements IBridge{
    @Override
    public void bridgeMethod() {
        System.out.println("Car bridge method");
    }
}
class TrackBridge implements IBridge{
    @Override
    public void bridgeMethod() {
        System.out.println("Track bridge method");
    }
}

class ToyotaCar extends ICar{
    public ToyotaCar(IBridge iBridge) {
        super(iBridge);
    }
    @Override
    public void drive() {
        System.out.println("Toyota car");
    }
}
class ToyotaTrack extends ITrack{
    public ToyotaTrack(IBridge iBridge) {
        super(iBridge);
    }
    @Override
    public void drive() {
        System.out.println("Toyota track");
    }
}

// EXAMPLE OF BAd ierarxii
//interface ICar{ void drive();}
//class Toyota implements ICar{}
//class Audi implements ICar{}
//
//interface ITrack{ void drive();}
//class Toyota implements ITrack{}
//class Audi implements ITrack{}