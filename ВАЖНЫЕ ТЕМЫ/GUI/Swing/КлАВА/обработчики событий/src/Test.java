import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

public class Test{
    private List<MyEventListener> eventListeners = new LinkedList<>();

    public void addEventListener(MyEventListener eventListener){
        eventListeners.add(eventListener);
    }

    public void notifyEventListeners(MyEvent event){
        for(MyEventListener eventListener : eventListeners){
            eventListener.processEvent(event);
        }
    }
}
