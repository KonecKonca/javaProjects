import java.awt.*;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class start{
    public static void main(String[] args) throws Exception {
        if(Desktop.isDesktopSupported()){  // если ф-ия поддерживается
            Desktop desktop = Desktop.getDesktop();
            for(Desktop.Action action : Desktop.Action.values()){
                System.out.println(action);  // вывод возможных операций
            }
            if(desktop.isSupported(Desktop.Action.BROWSE)){
                desktop.browse(new URI("https://vk.com/evgeniu.botvinnikov"));
            }

            if(desktop.isSupported(Desktop.Action.OPEN)){
                desktop.open(new File("C:\\Users\\Андрей\\Desktop\\текстовые"));  // папку открыть
                desktop.open(new File("C:\\Users\\Андрей\\Desktop\\текстовые\\джава.txt"));  // файл
            }
        }
    }
}

