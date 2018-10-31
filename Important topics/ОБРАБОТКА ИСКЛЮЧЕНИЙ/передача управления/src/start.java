import java.awt.*;
import java.util.*;
import java.util.List;

public class start{
    public static void main(String[] args) {
        System.out.println("main");
        x1();
        System.out.println("main");
    }

    static void x1(){
        System.out.println("x1");
        try {
            x2();
        }
        catch(Exception ex){
            System.out.println("Поймали");
        }
        System.out.println("x1");
    }

    static void x2()throws Exception{
        System.out.println("x2");
        x3();
        System.out.println("x2");
    }

    static void x3 () throws Exception{
        System.out.println("x3");
        throw new Exception();
        // System.out.println("sfsfsff");  // дальше нельзя ничего писать(недостижимый код) т.е 2 искла одновременно не вылетают!!!
    }
}
