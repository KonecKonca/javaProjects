/**
 * Created by Андрей on 02.01.2018.
 */
public class dop {
    private int hour;
    private int minute;
    private int second;

    public void set_time(int h, int m, int s){
        hour = ((h>0 && h<24) ? h : 0);
        minute = ((m > 0 && m < 60) ? m : 0);
        second = ((s > 0 && s < 60) ? s : 0);
    }

    public String vivod(){
        return String.format("%d:%02d:%02d %s",((hour == 0 || hour == 12) ? 12 : hour%12), minute, second, ((hour < 12) ? "AM" : "PM"));
    }

}
