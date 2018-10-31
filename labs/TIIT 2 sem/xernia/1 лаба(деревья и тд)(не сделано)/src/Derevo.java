/**
 * Created by Андрей on 29.01.2018.
 */
public class Derevo{
    private int ID;
    private int znachenie;
    public Derevo right;
    public Derevo left;

    public int getID(){
        return ID;
    }
    public int getZnachenie(){
        return znachenie;
    }

    public void setID(int id){
        if(id >=0 && id <999999){
            ID = id;
        }
        else{
            ID = -1;
        }
    }

    public void setZnachenie(int z){
        if(znachenie >=0 && znachenie < 999999){
            znachenie = z;
        }
        else {
            znachenie = -1;
        }
    }

}
