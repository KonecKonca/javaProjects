/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args){
        Random random = new Random();
        for(int i = 0; i<20; i++) {
            System.out.print(random.nextInt(2) + " ");
        }
    }
}
