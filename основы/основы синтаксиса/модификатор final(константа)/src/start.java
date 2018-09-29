/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;
import java.util.EnumSet;

public class start {
    public static void main(String[] args) {
        dop finalObj = new dop(4);
        for(int i = 0; i<10; i++) {
            finalObj.add();
            finalObj.vivod();
        }
    }
}
