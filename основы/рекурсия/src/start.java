/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
        int a = vvod.nextInt();
        System.out.println("Факториал " + a + " = " + recys(a));
        System.out.println("Сумма от 1 до " + a + " = " + sum(a));
    }

    public static int recys(int n){
        int pr = 1;
        if(n == 1){
            return 1;
        }
        return pr = n * recys(n-1);
    }

    public static int sum(int a){
        if(a == 1){
            return 1;
        }
        return (a + sum(a - 1));
    }
}



