/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int length;
        length = vvod.nextInt();
        int mass[] = new int[length];
        Random random = new Random();
        for(int i =0; i<mass.length; i++){
            mass[i] = random.nextInt(11);
            System.out.print(mass[i] + "  " + "");
        }
    }
}
