import com.sun.deploy.util.SyncAccess;

import java.util.*;

public class start {
    public static void main(String[] args) {
        start s = new start();
        System.out.println(s instanceof Object); // так как он наследник
        System.out.println(s instanceof start);
        System.out.println(s instanceof List);  // не является наследником
    }
}
