import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.text.html.HTMLDocument;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        Originator originator = new Originator();
        originator.setState("one");
        System.out.println(originator.getState());

        CareTaker careTaker = new CareTaker();
        careTaker.setMomemto(originator.createMomemto());

        originator.setState("two");
        System.out.println(originator.getState());

        originator.setDataFromMomento(careTaker.getMomemto());
        System.out.println(originator.getState());
    }
}

class Originator{
    private String state;
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }

    public Momemto createMomemto(){
        return new Momemto(state);
    }
    void setDataFromMomento(Momemto momemto){
        this.state = momemto.getState();
    }
}

class Momemto{
    private String state;

    public Momemto(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}

class CareTaker{
    private Momemto momemto;

    public Momemto getMomemto() {
        return momemto;
    }
    public void setMomemto(Momemto momemto) {
        this.momemto = momemto;
    }
}






















