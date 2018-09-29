import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        Template template = new Job();
        template.run();
    }
}

abstract class Template{
    abstract void stepOne();
    abstract void stepTwo();
    abstract void stepThree();

    void run(){
        stepOne();
        stepTwo();
        stepThree();
    }
}

class Job extends Template{
    @Override
    void stepOne() {
        System.out.println("First step");
    }
    @Override
    void stepTwo() {
        System.out.println("Second Step");
    }
    @Override
    void stepThree() {
        System.out.println("Third Step");
    }
}
