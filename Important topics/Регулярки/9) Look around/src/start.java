import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class start {
    public static void main(String[] args) {        // q(?=(?=u)) -- чтобы нельзя было по номеру обратиться (Т.к одинаковые обознач, то нужно обернуть)
        Pattern p = Pattern.compile("q(?=u)");   // q(!=u)  чтобы u не было после q
        Matcher m = p.matcher("aaaqui");
        while (m.find()){
            System.out.println(m.start()  + " " + m.group());
        }

        Pattern p1 = Pattern.compile("(?<!a)b");  // ?<= -- то где должна быть предидущ буква
        Matcher m1 = p1.matcher("abquib");
        while (m1.find()){
            System.out.println(m1.start()  + " " + m1.group());
        }



    }
}
