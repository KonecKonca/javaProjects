/**
 * Created by Андрей on 03.01.2018.
 */
public class dop {
    private String name;
    private static int kolPers = 0;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void show(){
        kolPers++;
        System.out.printf("%s - наш персонаж №%d\n",name, kolPers);
    }

    public static int getKol(){
        return kolPers;
    }
}
