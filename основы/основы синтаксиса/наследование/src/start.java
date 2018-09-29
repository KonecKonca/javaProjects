/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;
import java.util.EnumSet;

public class start {
    public static void main(String[] args) {
        dop d = new dop();
        baza b = new baza();
        d.getChiclo(45);
        b.getChiclo(445);
        d.show();
        b.show();
    }
}
