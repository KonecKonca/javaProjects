/**
 * Created by Андрей on 03.01.2018.
 */
public class dop {
    private  int sum;
    private final int num;

    public dop(int n){
        num = n;
    }

    public void add(){
        sum += num;
    }

    public void vivod(){
        System.out.println("Сума = " + sum);
    }
}
