import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

// Хранение данных между запусками программы
// на винде хранятся в реестре(зависит от операционки)
// ПРоще чем работать с файлами
public class start{
    public static void main(String[] args) throws Exception{
        Preferences user = Preferences.userRoot();  // или Preferences.systemRoot();  // завит в какой папке будут храниться данные
        user.put("key", "value");
        System.out.println(user.get("key", "default value"));
        Preferences node = user.node("myPackage");
        node.put("one", "1");  // создали вложенный каталог
        System.out.println(node.getInt("one", 2));  // + дефолтовое значение

//        Preferences mypackage = Preferences.userNodeForPackage(Preferences.class);  // альтернатива создания вложенного каталога
        user.exportSubtree(new FileOutputStream("MyPreferences.xml"));  // для возможности переноса(на другой пк)
    }
}
