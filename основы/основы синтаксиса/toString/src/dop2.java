/**
 * Created by Андрей on 03.01.2018.
 */
public class dop2 {
    private  String name;
    private  dop d;

    public dop2(String n, dop dd){
        name = n;
        d = dd;
    }

    public String toString(){
        return String.format("Меня зовут %s, я родился - %s!!!", name, d);
    }

}
