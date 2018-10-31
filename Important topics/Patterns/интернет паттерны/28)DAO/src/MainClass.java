import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.omg.CORBA.portable.ValueInputStream;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        Data data = new FileSystem();
        System.out.println(data.getData());

        System.out.println("\n-------------------------------\n");

        data = new Db();
        System.out.println(data.getData());
    }
}

interface Data{
    String getData();
}

class Db implements Data{
    String getFromTable(){
        return "data from DB";
    }

    @Override
    public String getData() {
        return getFromTable();
    }
}
class FileSystem implements Data{
    String getFromFS(){
        return "data from FS";
    }

    @Override
    public String getData() {
        return getFromFS();
    }
}

