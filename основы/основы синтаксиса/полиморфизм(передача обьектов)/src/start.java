/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args){
        user u = new user();
        figure f = new figure();
        u.use(f);
        circle c = new circle();
        u.use(c);
        rectangle r = new rectangle();
        u.use(r);
    }
}
