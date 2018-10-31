import java.util.ArrayList;
        import java.util.List;

public class RadioButton implements OnOfListener{
    private int myX;
    private int myY;
    public boolean on = false;
    private String name = "";

    public RadioButton(int x, int y, String name) {
        this.myX = x;
        this.myY = y;
        this.name = name;
        Mouse.addListener((e1, e2) -> {
            if(((myX - e1) * (myX - e1) + (myY - e2) * (myY - e2)) < 100) {  // чтоб нихуя не имплементить (и не кидать this), ебашим inner анонимку
                on = true;                                                     // которая нарушает инкапсуляцию(видит myX  myY)
                for(OnOfListener onOfListener : listeners){
                    onOfListener.inOn();
                }
            }
        });
    }


    private List<OnOfListener> listeners = new ArrayList<>();
    public void addListener(OnOfListener listener){
        listeners.add(listener);
    }

    @Override
    public void inOn() {
        this.on = false;
    }
}
