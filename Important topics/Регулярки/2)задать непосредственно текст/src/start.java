import javafx.scene.Parent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://regexone.com   -- тренировка регулярок
public class start {
    public static void main(String[] args) {

        // спец символы
        // []\^$.|?*+()

        // просто поиск слова
        Pattern p = Pattern.compile("aaaa");
        Matcher m = p.matcher("aaaa bbbb aaaa bbbb dfdfdf ddddd dd vvv aaaaaa aaa");
        while(m.find()){
            System.out.println(m.start() + " " + m.group() + " ");
        }
        System.out.println();

        // дословные выражения
        //   \Q1+1=2\E       (для джавы соответственно нужно проэкранировать слэши)
        Pattern p1 = Pattern.compile("\\Q1+1=2\\E ");
        Matcher m1 = p1.matcher("1+1=2 dfdfdf 1+1=2 vv aaaa 1+1=2 ");
        while(m1.find()){
            System.out.println(m1.start() + " " + m1.group() + " ");
        }
        System.out.println();

    }
}
