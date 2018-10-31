import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.text.html.HTMLDocument;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){

        Mediator mediator = new ConcreteMediator();
        Collegue collegue1 = new ConcreteCollegue(mediator, "Andrei");
        Collegue collegue2 = new ConcreteCollegue(mediator, "Vasia");
        Collegue collegue3 = new ConcreteCollegue(mediator, "Petia");
        List<Collegue> list = new ArrayList<>(Arrays.asList(collegue1, collegue2, collegue3));
        show(list);

        list.get(0).setTrue();
        list.get(2).setTrue();
        show(list);

        list.get(1).changeStatus();
        show(list);

        list.get(0).changeStatus();
        show(list);
    }

    static void show(List<Collegue> list){
        for(Collegue collegue : list){
            collegue.showStatus();
        }
        System.out.println("\n---------------------------------\n");
    }
}

interface Mediator{
    void changeCombo(Collegue collegue);
    void add(Collegue collegue);
}
class ConcreteMediator implements Mediator{
    private List<Collegue> collegues = new ArrayList<>();
    @Override
    public void add(Collegue collegue){
        collegues.add(collegue);
    }
    @Override
    public void changeCombo(Collegue collegue) {
        collegue.setTrue();
        for(Collegue coll : collegues){
            if(coll != collegue){
                coll.setFalse();
            }
        }
    }
}

interface Collegue{
    void setFalse();
    void setTrue();
    void changeStatus();
    void showStatus();
}
class ConcreteCollegue implements Collegue{
    private boolean status;
    private Mediator mediator;
    private String name;
    public ConcreteCollegue(Mediator mediator, String name) {
        this.mediator = mediator;
        mediator.add(this);
        this.name = name;
    }

    @Override
    public void setFalse() {
        status = false;
    }
    @Override
    public void setTrue() {
        status = true;
    }
    @Override
    public void changeStatus() {
        mediator.changeCombo(this);
    }
    @Override
    public void showStatus() {
        System.out.println(name + " - " + status);
    }
}









































