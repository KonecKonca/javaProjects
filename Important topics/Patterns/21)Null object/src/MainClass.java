import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        Animal animal = getAnimal();
        animal.eat();
    }

    static Animal getAnimal(){
        try {
            if(new File("nosuchfile.txt").exists()){
                // Any activity here
                return new Lion();
            }
        }
        finally {
            return new noAnimal();
        }
    }
}

interface Animal{
    void eat();
}

class Lion implements Animal{
    @Override
    public void eat() {
        System.out.println("Lion eat");
    }
}

class noAnimal implements Animal{
    @Override
    public void eat() { }
}










