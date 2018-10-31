import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class start {
    public static void main(String[] args) {

        // Фишка в том что вперёд\назад смотряфщие сами по себе длинны 0
        Pattern p = Pattern.compile("(?=\\b.{7}\\b)\\w*cat\\w*");  // что-то из 7-ти букв, содержащее cat
        Matcher m = p.matcher("w~wcate упуп уп erger g 77cate7 egeggg e g 1112cat wfdwf ");
        while (m.find()){
            System.out.println(m.start()  + " " + m.group());
        }

        System.out.println("\n---------------------------------\n");
        // слово длинной 7-15 букв с 1 из (cat, xyi, alax)
        Pattern p1 = Pattern.compile("\\b(?=\\w{7,15}\\b)\\w*(cat|xyi|alax)\\w*");
        Matcher m1 = p1.matcher("traata ta-e egfegrgrfgbf btghgt alax1 alaxyakbar xyiofcat catde1e catxyi wef alax11");
        while (m1.find()){
            System.out.println(m1.start()  + " " + m1.group());
        }

    }
}
