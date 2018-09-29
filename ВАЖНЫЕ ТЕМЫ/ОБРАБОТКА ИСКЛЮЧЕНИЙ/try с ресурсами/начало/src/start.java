import com.sun.deploy.util.SyncAccess;

import java.io.*;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.newObjectType;


public class start {
    public static void main(String[] args) throws Exception {


        // Очень длинный вариант из-за обработки исключений
        Reader reader = null;
        try {
            reader = new FileReader(new File("someFail"));
        } catch (FileNotFoundException e) {  // если не удалось создать файл
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {   // если не удалось закрыть файл
                e.printStackTrace();
            }
//        }

//////////////////////////////////////////////////////////////////////////////////

            // Здесь метод close() вызывается автоматически (если передаём классы, которые имллементят автоклоузабл) наприсмер для считывания из файлов
            try (Reader reader1 = new FileReader(new File("someFail"))) {  // можно не только 1 параметр
            } catch (IOException e) {
                System.out.println("gdsgsesgr");
            }


            // также если не выьрас ошибка, то можно обойтись без catch и finally
            try (Reader reader1 = new FileReader(new File("someFail"))) {

            }

        }
    }
}

