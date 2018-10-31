/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args){

        SimpleEnum svetofor = SimpleEnum.green;
        if(SimpleEnum.green == svetofor){
            System.out.println("Верно цвет -- " + svetofor + "\n\n");
        }

        Nedilia nedilia = Nedilia.monday;
        System.out.println(nedilia);
        System.out.println(nedilia.getZnach());
        System.out.println("\n");
        Nedilia nedilia1 = Nedilia.sanday;
        System.out.println(nedilia.getDopZnach());
        System.out.println(nedilia1.getDopZnach());
    }
}

// это как устроен enum
class Nedelia2{
    public static final Nedelia2 monday2 = new Nedelia2();
    // и так далее
}

