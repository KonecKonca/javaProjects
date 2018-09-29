import javafx.scene.Parent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class start {
    public static void main(String[] args) {
//        Pattern p = Pattern.compile(" is ");
        Pattern p = Pattern.compile("\\bis\\b");  // эффект тот же

        Matcher m = p.matcher("this island is beautiful");
        while (m.find()){
            System.out.println(m.start() + " " + m.group());
        }
    }
}
