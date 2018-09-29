package first;

import java.util.Scanner;

/**
 * Created by Андрей on 16.11.2017.
 */
public class first {
    public static void main(String[] args) {
        Scanner vvod = new Scanner(System.in);
        System.out.println("Введите значение");
        int a = vvod.nextInt();
        check(a);
    }
    public static void check(int a){
        switch (a) {
            case 1:
                System.out.println("1111111");
                break;
            case 2:
                System.out.println("2222222");
                break;
            case 3:
                System.out.println("33333");
                break;
            default:
                System.out.println("Увы !!!!!");
                break;
        }
    }
}
