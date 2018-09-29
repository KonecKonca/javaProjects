/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;
import java.util.EnumSet;

public class start {
    public static void main(String[] args) {
        for (parametri i : parametri.values()) { //проход по всем елементам
            System.out.printf("%s - %d и %d\n", i, i.getdesk1(), i.getdesk2());
        }
        System.out.println("\nВывод диапазоном");
        for (parametri i : EnumSet.range(parametri.x3, parametri.xrenchik)) { //проход по всем елементам
            System.out.printf("%s - %d и %d\n", i, i.getdesk1(), i.getdesk2());
        }
    }
}
