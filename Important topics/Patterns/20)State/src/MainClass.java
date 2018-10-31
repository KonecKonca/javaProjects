import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.text.html.HTMLDocument;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        Context context = new Context(new LoverCase(), "Andrei");
        context.doAction();

        context.setState(new UpperCase());
        context.doAction();
    }
}

interface State{
    void doAction(Context context);
}

class LoverCase implements State{
    @Override
    public void doAction(Context context) {
        System.out.println(context.getName().toLowerCase());
    }
}

class UpperCase implements State{
    @Override
    public void doAction(Context context) {
        System.out.println(context.getName().toUpperCase());
    }
}

class Context{
    private State state;
    private String name;
    public String getName() {
        return name;
    }
    public void setState(State state) {
        this.state = state;
    }

    public Context(State state, String name) {
        this.state = state;
        this.name = name;
    }

    void doAction(){
        state.doAction(this);
    }
}




















