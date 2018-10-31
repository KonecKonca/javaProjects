/**
 * Created by Андрей on 31.12.2017.
 */

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.util.*;

public class start{
    public static void main(String[] args) {
        Thread hero1 = new Thread(new Heroes("Andrei"));
        Thread hero2 = new Thread(new Heroes("Jeka"));
        Thread hero3 = new Thread(new Heroes("Vasia"));
        Thread hero4 = new Thread(new Heroes("Xer"));

        hero1.start();
        hero2.start();
        hero3.start();
        hero4.start();
    }
}
