import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mouse {
    private static List<MouseListener> listeners = new ArrayList<>();

    public static void click(int newX, int newY){
        for(MouseListener listener : listeners){
            listener.mouseClicked(newX, newY);
        }
    }

    public static void addListener(MouseListener listener){
        listeners.add(listener);
    }
}
