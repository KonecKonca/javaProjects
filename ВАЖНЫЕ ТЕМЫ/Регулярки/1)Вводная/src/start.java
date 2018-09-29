import javafx.scene.Parent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// сtrl + R ---- для обработки своего кода регулярками
public class start {
    public static void main(String[] args) {

        // проверка строки
        System.out.println("dhthdtdh".matches("[а-я]*"));
        System.out.println("аыфкпр".matches("[а-я]*"));
        System.out.println();

        // другой способ
        Pattern p = Pattern.compile("мой текст");
        Matcher m = p.matcher("any xren, мой текст");
        while(m.find()){
            System.out.println(m.start() + " " + m.group() + " ");
        }
        System.out.println();
    }
}


//  111 xxxxxxxx керркеварееркывпррк
//          renamed
//  renamed
//       renamed
// renamed
        // renamed
// renamed
