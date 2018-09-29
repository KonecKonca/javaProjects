import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.omg.CORBA.portable.ValueInputStream;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            while (scanner.hasNext()){
                new DispatherServlet().process(scanner.nextLine());
            }
        }
    }
}

class DispatherServlet{
    void process(String url){
        switch (url){
            case "home" : new HomeController().show(); break;
            case "user" : new HomeController().show(); break;
            default: new DefaultController().show();
        }
    }
}

class HomeController{
    public void show(){
        System.out.println("Home page");
    }
}
class UserController{
    public void show(){
        System.out.println("User page");
    }
}
class DefaultController{
    public void show(){
        System.out.println("Error");
    }
}