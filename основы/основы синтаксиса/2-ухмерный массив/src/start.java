/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args) {
        Scanner vvod = new Scanner(System.in);
        Random random = new Random();
        int str;
        int stlb;
        System.out.println("Введите кол-во строк");
        str = vvod.nextInt();
        System.out.println("Введите кол-во столбцов");
        stlb = vvod.nextInt();
        int mass[][] = new int[str][stlb];
        System.out.println("Наш 2-ухмерный массив");
        for(int i =0; i<str; i++){
            for(int j = 0; j<stlb; j++){
                mass[i][j] = random.nextInt(10);
                System.out.print(mass[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
