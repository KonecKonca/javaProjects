/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.*;

public class start {
    public static void main(String[] args) {
        Integer[] iArray = {1, 2 ,3 ,4, 65, 657, 5};
        String[] sArray = {"a", "b", "c", "d"};
        print(iArray);
        print(sArray);

        System.out.println(min(34, 3, 221));
    }

    public static <T> void print(T[] mass){
        for(T x : mass){
            System.out.print(x + "  ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> T min(T a, T b, T c){  //  без extends Comparable<T> ф-я сравнения не сработает
        T m = a;
        if(b.compareTo(a) < 0){  // compare выдает рез < 0 если б меньше а
            m = b;
        }
        if(c.compareTo(m) < 0){
            m = c;
        }
        return m;
    }
}
