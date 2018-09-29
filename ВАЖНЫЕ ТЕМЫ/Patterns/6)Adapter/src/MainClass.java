import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        CarsWash carsWash = new CarsWash();
        carsWash.washCar(new Audi());
        carsWash.washCar(new TrackAdapter(new MyTrack()));
    }
}

interface Car{
    void wash();
}
class Audi implements Car{
    @Override
    public void wash() {
        System.out.println("Audi washing");
    }
}

interface Track{
    void clear();
}
class MyTrack implements Track{
    @Override
    public void clear() {
        System.out.println("Track is clearing");
    }
}
class TrackAdapter implements Car{
    private Track track;
    public  TrackAdapter(Track track){
        this.track = track;
    }
    @Override
    public void wash() {
        track.clear();
    }
}

class CarsWash{
    public void washCar(Car car){
        car.wash();
    }
}
