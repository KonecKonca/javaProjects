import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class start {
    public static void main(String[] args) {

        Pattern p = Pattern.compile("\\p{Punct}");
        Matcher m = p.matcher("reg df ?  w a7#%# %# ");
        while (m.find()){
            System.out.println(m.start()  + " " + m.group());
        }


    }
}
