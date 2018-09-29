import javafx.scene.Parent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class start {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[a-c1-37]");  // тупо всё что нам надо
        Matcher matcher = pattern.matcher("abc dc e1234567890");
        while (matcher.find()){
            System.out.println(matcher.start() + " " + matcher.group());
        }

        // специальные внутри набора ----
        //                      \   - экранирование
        //                       ^  - отрицание (только перед отрицаемым символом)
        //                      -    - для диапазона
        // остальные символы в квадратных скобках не являются специальными

        // СОКРАЩЕНИЯ  (Тоже с большоя для всех есть отрицание)
        // нам соответсвенно нужно фигачить не \ а \\
        //  \d - все цифры(\D не цифры)          \w -- любой символ, кроме пробела
        //  \s - пробел или таб

    }
}
