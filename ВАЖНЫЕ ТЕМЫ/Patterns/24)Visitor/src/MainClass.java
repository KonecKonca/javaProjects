import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.omg.CORBA.portable.ValueInputStream;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        Animal animal = new Dog();
        animal.doJob(new ConcreteVisitor());

        System.out.println("\n--------------------\n");

        animal = new Cat();
        animal.doJob(new ConcreteVisitor());
    }
}

interface Animal{
    void doJob(Visitor visitor);
}
class Dog implements Animal{
    @Override
    public void doJob(Visitor visitor) {
        visitor.doDog();
    }
}
class Cat implements Animal{
    @Override
    public void doJob(Visitor visitor) {
        visitor.doCat();
    }
}

interface Visitor{
    void doDog();
    void doCat();
}
class ConcreteVisitor implements Visitor{
    @Override
    public void doDog() {
        System.out.println("gaw gaw");
    }

    @Override
    public void doCat() {
        System.out.println("miao miao");
    }
}

