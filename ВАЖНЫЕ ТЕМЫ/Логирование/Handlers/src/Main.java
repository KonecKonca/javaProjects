import java.util.logging.*;

public class Main {
    private static final Logger loger = Logger.getLogger(Main.class.getName()); // просто будет своё имя (этот обычно и юзается)

    public static void main(String[] args) throws Exception {
//        new FileHandler();
//        new StreamHandler();
//        new SocketHandler();
        Handler fileHandler = new FileHandler();
        Handler consoleHandler = new ConsoleHandler();

        loger.setUseParentHandlers(false);  // что логирование в дефолтное рассположение (отключили в консоль)
        loger.addHandler(fileHandler); // логируетсяф в файл (C:\\user\\Андрей) имя(java0.log)
        loger.addHandler(consoleHandler);  // и потом опять включили вывод логов в консоль
        loger.info("info");

    }
}
