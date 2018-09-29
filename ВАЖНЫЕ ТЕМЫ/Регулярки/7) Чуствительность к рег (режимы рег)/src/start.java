import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class start {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("a", Pattern.CASE_INSENSITIVE);  // пофиг на регистр
        Matcher m = p.matcher("A a A");
        while (m.find()){
            System.out.println(m.start()  + " " + m.group());
        }
        System.out.println("AA".matches("(?i)a(?-i)A"));  // на протяжении 1-ой строки можно менять режимы
                                                    // (?-i:A)  отключели режим только для выражения , стоящего после :
    }
}
