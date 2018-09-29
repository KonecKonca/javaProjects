/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;

public class start {
    public static void main(String[] args){
       Scanner vvod = new Scanner(System.in);
       String name = vvod.nextLine();
        System.out.printf("Привет, меня зовут %s, и я рад знакомству", name);
    }
}
