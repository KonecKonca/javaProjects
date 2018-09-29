import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static void main(String[] args){
        //  у нас не будет повторяющихся объектов по указонному критерию
        FlyWieghtGarage flyWieghtGarage = new FlyWieghtGarage();
        Mercedes mercedes1 = flyWieghtGarage.getMercedes("green");
        Mercedes mercedes2 = flyWieghtGarage.getMercedes("red");
        Mercedes mercedes3 = flyWieghtGarage.getMercedes("green");
        Mercedes mercedes4 = flyWieghtGarage.getMercedes("yellow");
        flyWieghtGarage.getMercedes("yellow");

        Map<String, Mercedes> map = flyWieghtGarage.getMap();
        for(Map.Entry<String, Mercedes> entry : map.entrySet()){
            System.out.println(entry.getKey());
        }
    }
}

class Mercedes{
    private String color;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}

class FlyWieghtGarage{
    private Map<String, Mercedes> map = new HashMap<>();

    public Mercedes getMercedes(String color){
        Mercedes mercedes = map.get(color);
        if(mercedes == null){
            mercedes = new Mercedes();
            mercedes.setColor(color);
            map.put(color, mercedes);
        }
        return mercedes;
    }

    public Map<String, Mercedes> getMap(){
        return map;
    }
}

