import java.util.ArrayList;
import java.util.List;

public class Grafic {
    List<String> firstElements;
    List<String> secondElements;

    public Grafic(List<String> firstElements, List<String> secondElements){
        this.firstElements = firstElements;
        this.secondElements = secondElements;
    }
    public Grafic(){
        this.firstElements = new ArrayList<>();
        this.secondElements = new ArrayList<>();
    }

    @Override
    public String toString() {
        return firstElements.toString() + " " + secondElements.toString();
    }
}
