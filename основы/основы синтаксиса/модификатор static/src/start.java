/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;
import java.util.EnumSet;

public class start {
    public static void main(String[] args) {
        Scanner vvod = new Scanner(System.in);
        System.out.println("Введите кол-во персонажей");
        int kol = vvod.nextInt();
        dop mass[] = new dop[kol];
       for(int i = 0; i<kol; i++){
            System.out.println("Введите имя персонажа");
            String name = vvod.next();
            mass[i] = new dop();
            mass[i].setName(name);
        }
        for(int i = 0; i<kol; i++){
           mass[i].show();
        }
        System.out.println("кол-во героев " + dop.getKol());
    }
}
