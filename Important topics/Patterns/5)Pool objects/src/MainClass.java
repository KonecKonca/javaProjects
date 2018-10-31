import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        PoolObject poolObject1 = new PoolObject();
        poolObject1.setStr("objet 1111111111");
        PoolObject poolObject2 = new PoolObject();
        poolObject2.setStr("objet 2222222222");

        Pool pool = new Pool();
        pool.releasedPoolObject(poolObject1);
        pool.releasedPoolObject(poolObject2);


        PoolObject poolObject3 = pool.getPoolObject();
        System.out.println(poolObject3.getStr());

        PoolObject poolObject4 = pool.getPoolObject();
        System.out.println(poolObject4.getStr());

        PoolObject poolObject5 = pool.getPoolObject();
        System.out.println(poolObject5.getStr());

        poolObject5.setStr("Reused");
        pool.releasedPoolObject(poolObject5);
        PoolObject poolObject6 = pool.getPoolObject();
        System.out.println(poolObject6.getStr());

    }
}

class PoolObject{
    private String str = "XxXXXXX";
    public String getStr() {
        return str;
    }
    public void setStr(String str) {
        this.str = str;
    }
}

class Pool{
    List<PoolObject> free = new LinkedList<>();
    List<PoolObject> used = new LinkedList<>();

    public PoolObject getPoolObject(){
        if(free.isEmpty()){
            PoolObject poolObject = new PoolObject();
            free.add(poolObject);
            return poolObject;
        }
        else {
            PoolObject poolObject = free.get(0);
            used.add(poolObject);
            free.remove(poolObject);
            return poolObject;
        }
    }

    public void releasedPoolObject(PoolObject poolObject){
        used.remove(poolObject);
        free.add(poolObject);
    }
}
