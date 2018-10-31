/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args) {
        dop time = new dop();
        System.out.println(time.vivod());
        time.set_time(15,34,54);
        System.out.println(time.vivod());
    }
}
