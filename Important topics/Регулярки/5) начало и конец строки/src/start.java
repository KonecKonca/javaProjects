import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class start {
    public static void main(String[] args) {
        // ^ (\A) -- вне квадрат ковычек является символом начала строки
        // $ (\Z) -- символ конца строки

        Pattern p = Pattern.compile(".$");  // так же и с началом строки
        Matcher m = p.matcher("1 4323  343 22 334 54 44X");
        while (m.find()){
            System.out.println(m.start() + " " + m.group());
        }

        Pattern p1 = Pattern.compile("......", Pattern.MULTILINE); // теперь вомпринимается всё как оно есть (согласно \n)

    }
}
