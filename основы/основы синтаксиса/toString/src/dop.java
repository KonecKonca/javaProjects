/**
 * Created by Андрей on 03.01.2018.
 */
public class dop {
    private int year;
    private  int mounth;
    private int day;

    public dop(int d, int m, int y){
        day = d;
        mounth = m;
        year = y;
        System.out.printf("День рождения - %s\n", this);
    }

    public String toString(){
        return String.format("%d/%d/%d", day, mounth, year);
    }

}
