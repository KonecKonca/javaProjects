/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args){
        figure[] mass = new figure[3];
        mass[0] = new figure();
        mass[1] = new rectangle();
        mass[2] = new circle();
        for (int i = 0; i<mass.length; i++){
            mass[i].vivod();
        }
    }
}
