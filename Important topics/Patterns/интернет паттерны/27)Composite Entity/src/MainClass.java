import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.omg.CORBA.portable.ValueInputStream;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        UnionObject unionObject = new UnionObject();
        for(String str : unionObject.getData()){
            System.out.println(str);
        }
    }
}

class DependentObject1{
    public String getData(){
        return "one";
    }
}
class DependentObject2{
    public String getData(){
        return "two";
    }
}

class UnionObject{
    private DependentObject1 dependentObject1 = new DependentObject1();
    private DependentObject2 dependentObject2 = new DependentObject2();
    public String[] getData(){
        return new String[] {dependentObject1.getData(), dependentObject2.getData()};
    }
}