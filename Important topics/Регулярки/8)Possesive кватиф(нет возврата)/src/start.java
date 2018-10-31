import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class start {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\".*\"");
        Matcher m = p.matcher("\"111323\"w");
        while (m.find()){
            System.out.println(m.start()  + " " + m.group());
        }

        System.out.println("Possesive пососал");
        Pattern p1 = Pattern.compile("\".*+\"");
        Matcher m1 = p1.matcher("\"111323\"w ");
        while (m1.find()){
            System.out.println(m1.start()  + " " + m1.group());
        }

    }
}
