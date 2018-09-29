import java.util.logging.Level;
import java.util.logging.Logger;

// обычно логируются классы
public class Main {
    private static final Logger loger = Logger.getGlobal();
    private static final Logger loger2 = Logger.getLogger(Main.class.getName()); // просто будет своё имя (этот обычно и юзается)
    // можно выборочно выбирать логи, более гибкая настройка

    // Есть некоторые уровни в логе(по дефолту INFO), указыаю самай жёсткий указываются онли самые жёсткие, самый лайт - вообще всё

    // часто создаётся новая лог-конфигурация(создаётся новый файлик)
    public static void main(String[] args) throws Exception {
        loger.log(Level.FINER, "finer");
        loger.log(Level.INFO, "info");
        loger.log(Level.WARNING, "warning");   //место строки можно выкинуть исключение
    }
}
