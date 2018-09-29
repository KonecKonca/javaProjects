/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args) {
        System.out.println("Среднее = " + av(5,5,5,6,6,6,6));
    }

    public static double av(int...num){
        int sum = 0;
        for(int i:num){
            sum += i;
        }
        return (double) sum/num.length;
    }

}
