/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args){
        try {
            dop();
        }catch (Exception ex){
            System.out.println("Еблан");
        }
    }

    public static void dop() throws Exception{
        System.out.println(8/0);
    }

}
