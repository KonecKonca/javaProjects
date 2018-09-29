import java.util.Formattable;
import java.util.Formatter;
import java.util.Locale;
import java.util.logging.*;

public class Main {
    private static final Logger loger = Logger.getLogger(Main.class.getName()); // просто будет своё имя (этот обычно и юзается)

    public static void main(String[] args) throws Exception {
        FileHandler fileHandler = new FileHandler("MyLog.log"); // конструктору можно передать директорию, куда сохранять файлы (%h/myJavaLog.log)
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFilter(new MyFilter());
        //consoleHandler.setFormatter(new MyFormatter());

        loger.setUseParentHandlers(false);  // (выведутся все если не отключим)
        loger.addHandler(consoleHandler);
        loger.addHandler(fileHandler); // и в файл тоже
        loger.info("info");
        loger.info("info max");
        loger.info("info2 max");
        loger.info("info3 max");
    }

    static class MyFilter implements Filter{
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("max");
        }
    }

//    static class MyFormatter extends Formatter{  // какого-то хера класс Formatter объявлен как final(вообще нужно для изменения вида вывода)
//        @Override
//        public String format(LogRecord record){
//            return record.getLevel() + ": " + record.getMessage();
//        }
//    }
}
