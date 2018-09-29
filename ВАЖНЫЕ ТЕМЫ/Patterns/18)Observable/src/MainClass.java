import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.text.html.HTMLDocument;
import java.text.MessageFormat;
import java.util.*;

// From Wikipedia
//public class MainClass {
//    public static void main(String[] args){
//        System.out.println("Enter text: ");
//        MyClass myClass = new MyClass();
//
//        myClass.addObserver((e1, e2) -> System.out.println("Received message " + e2));
//
//        new Thread(myClass).start();
//    }
//}
//
//class MyClass extends Observable implements Runnable{
//    @Override
//    public void run() {
//        while (true){
//            String message = new Scanner(System.in).next();
//            setChanged();
//            notifyObservers(message);
//        }
//    }
//}

public class MainClass{
    public static void main(String[] args) {
        Observer observer1 = new Observer("Andrei");
        Observer observer2 = new Observer("Vasia");

        observer1.setState("XXXXXxXXX");
        observer2.setState("YyyYYYYyyyY");
    }
}

class Observer{
    private static List<Observer> observers = new ArrayList<>();
    private String name;
    private String state;

    public Observer(String name) {
        this.name = name;
        observers.add(this);
    }
    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }
    private void notifyAllObservers(){
        for (Observer observer : observers){
            observer.update();
        }
    }
    private void update(){
        System.out.println(name + " change status: " + state);
    }
}

















