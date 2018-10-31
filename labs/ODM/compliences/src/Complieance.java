import java.util.ArrayList;
import java.util.List;

public class Complieance {
     List<String> oblOpred;
     List<String> oblZnach;
     Grafic grafic;

    public Complieance(List<String> oblOpred, List<String> oblZnach, Grafic grafic){
        this.oblOpred = oblOpred;
        this.oblZnach = oblZnach;
        this.grafic = grafic;
    }
    public Complieance(){
        oblOpred = new ArrayList<>();
        oblZnach = new ArrayList<>();
        grafic = new Grafic();
    }
}
