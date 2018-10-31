import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import  java.util.*;

// + --- можно менять значения не пересобирая проект
// + --- можно редачить руками через идею
public class start{
    public static void main(String[] args) throws Exception{
        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("net znach", "recieved default value");

        Properties properties = new Properties(defaultProperties);  // в коктрукторе дефолтовое значение(оно не будет записавться в файл)
//        properties.setProperty("one", "1");
//        System.out.println(properties.getProperty("one"));
//        FileOutputStream out = new FileOutputStream("my.properties");
//        properties.store(out, "my comments");  // добавить некоторые комментарии

        FileInputStream in = new FileInputStream("my.properties");
        properties.load(in);
        System.out.println(properties.getProperty("Vasia"));
        //System.out.println(properties.getProperty("net znach", "recieved default value"));
        System.out.println(properties.getProperty("net znach"));
    }
}

