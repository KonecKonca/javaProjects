import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MainClass {
    public static void main(String[] args) {
        Cell<DoJob> cell = new Cell<>();
        cell.setT(new DoJob());
        cell.doJob();

        Cell<DoJob> cell1 = new Cell<>();
        cell.setT(new ChildDoJob());
        cell.doJob();
    }
}

class DoJob implements Serializable, Cloneable{
    public void doIt(){
        System.out.println("It is done!!");
    }
}
class ChildDoJob extends DoJob{}

class Cell<T extends DoJob & Serializable & Cloneable>{
    T t;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }

    public void doJob(){
        t.doIt();
    }
}
