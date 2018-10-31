/**
 * Created by Андрей on 01.02.2018.
 */
public class Dannie {
    private String name;
    private int age;

    public Dannie(String str, int vozrast){
        name = str;
        age = vozrast;
    }
    public Dannie(int vozrast, String str){
        name = str;
        age = vozrast;
    }
    public Dannie(){}

    public void setName(String str){
        name = str;
    }
    public void setAge(int vozrast){
        age = vozrast;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
