import com.sun.deploy.util.SyncAccess;

import java.util.*;

public class start {
    public static void main(String[] args) {
       Runtime runtime = Runtime.getRuntime();
        System.out.println("Total memory " + runtime.totalMemory());
        System.out.println("Free memory " + runtime.freeMemory() + "\n");

        Date date = new Date();
        for(int i = 0; i<100000000; i++ ){
            date = new Date();
        }
        System.out.println("Free memory " + runtime.freeMemory() + "\n");

        System.gc();  // освобождение памяти(вернее запрос)
        System.out.println("Free memory " + runtime.freeMemory() + "\n");

        help h = new help();
        h = null;
        System.gc();
        h = new help();
        h = null;
        System.gc();
        h = new help();
        h = null;
        System.gc();
        h = new help();
        h = null;
        System.gc();
    }

    private static class help{
        int a;
        int b;
        public void finalize(){
            System.out.println("Вызван финализатор");
        }
    }
}
