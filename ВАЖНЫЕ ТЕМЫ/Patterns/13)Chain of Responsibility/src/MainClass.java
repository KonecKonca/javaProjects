import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static void main(String[] args){
        ConsoleMessagePrinter messagePrinter = new ConsoleMessagePrinter();
        FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();

        messagePrinter.setNextMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setNextMessagePrinter(new DBMessagePrinter());
        messagePrinter.print("HELLO!!!");
    }
}

abstract class MessagePrinter{
    MessagePrinter nextMessagePrinter;
    void setNextMessagePrinter(MessagePrinter messagePrinter){
        nextMessagePrinter = messagePrinter;
    }
    void print(String message){
       printMessage(message);
        if(nextMessagePrinter != null){
            nextMessagePrinter.print(message);
        }
    }
    abstract void printMessage(String message);
}

class ConsoleMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print into console: " + message);
    }
}
class DBMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print into DB: " + message);
    }
}
class FileMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print into TXT File: "  + message);
    }
}