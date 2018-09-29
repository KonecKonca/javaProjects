
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;
import java.util.Random;

public class start {
    public static void main(String[] args){
        int num1;
        int num2;
        double result;
        boolean check = true;

        do {
            try {
                Scanner vvod = new Scanner(System.in);
                System.out.println("ВВеди 1-ое число");
                num1 = vvod.nextInt();
                System.out.println("Введи 2-ое число");
                num2 = vvod.nextInt();
                result =(double) num1/num2;
                System.out.println(num1 +"/"+ num2 +"="+ result);
                check = false;
            }
            catch (Exception e){
                System.out.println("Тупая ослина ввела некоректные данные");
            }
        }while (check);

    }
}
