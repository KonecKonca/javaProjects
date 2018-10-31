import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static void main(String[] args){
        Command command = new MouseClick();
        command.execute();

        System.out.println("\n---------------------------\n");

        Receiver receiver = new Receiver();
        receiver.addCommand(new MouseClick());
        receiver.addCommand(new MouseMoved());
        receiver.addCommand(new MousePressed());
        receiver.run();
    }
}

interface Command{
    void execute();
}
class MouseClick implements Command{
    @Override
    public void execute() {
        System.out.println("MouseClicked method");
    }
}
class MousePressed implements Command{
    @Override
    public void execute() {
        System.out.println("MousePressed method");
    }
}
class MouseMoved implements Command{
    @Override
    public void execute() {
        System.out.println("MouseMoved method");
    }
}

class Receiver{
    private List<Command> list = new ArrayList<>();

    public void addCommand(Command command){
        list.add(command);
    }
    public void run(){
        for(Command command : list){
            command.execute();
        }
    }
}
