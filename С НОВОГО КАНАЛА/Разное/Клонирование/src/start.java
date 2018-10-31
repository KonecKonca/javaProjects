import java.awt.*;
import java.util.*;
import java.util.List;

public class start{
    public static void main(String[] args) throws Exception{
        Help help1 = new Help();
        help1.i = 11;
        help1.newNew.j = 111;
        System.out.println(help1.i + " " + help1.newNew.j + "\n");

        Help help2;
        help2 = help1.clone();
        help2.i = 22;
        help2.newNew.j = 222;
        System.out.println(help2.i + " " + help2.newNew.j + "\n");

        System.out.println(help1.i + " " + help1.newNew.j + "\n");
    }
}

