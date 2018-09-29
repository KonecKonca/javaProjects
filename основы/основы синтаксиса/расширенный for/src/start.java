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
        for(int i = 0; i<length; i++){
            System.out.println("Введи значение элемента № " + (i+1));
            mass[i] = vvod.nextInt();
        }
        int sum = 0;
        for(int i:mass){
            sum +=i;
        }
        System.out.println("Сума введённых чисел = " + sum);
    }
}
