import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class start {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("Set(?:Value){0,1}");  // ?: для группы не делать ссылку (для экономии ресурсов)
        Matcher m = p.matcher("Set or SetValue");
        while (m.find()){
            System.out.println(m.start()  + " " + m.group());
        }
        System.out.println("\n--------------------------------------\n");
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|xxx)", "$1 posleGroop'e")); // тут \1 (это только в самой регулярке) не проканало бы
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|xxx)", "$0 posleGroop'e"));  // 0 -- вся ругялярка
        System.out.println("\n--------------------------------------\n");

        Pattern p1 = Pattern.compile("<([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>");  // регулярка ищущая теги [^>] --  специальный обрыв   \\1 -- т.к теги парные (чтоьы не дублировать)
        Matcher m1 = p1.matcher("This is any <EM><I>first</I></EM> test with tags <P>second</P>");
        while (m1.find()){
            System.out.println(m1.start()  + " " + m1.group());
        }
        System.out.println();
        Pattern p2 = Pattern.compile("<([A-Z][A-Z0-9]*)[^>]*>.*?</[A-Z][A-Z0-9]*>");  // херь, не ловящая влож теги
        Matcher m2 = p2.matcher("This is any <EM><I>first</I></EM> test with tags <P>second</P>");
        while (m2.find()){
            System.out.println(m2.start()  + " " + m2.group());
        }
        System.out.println("\n--------------------------------------\n");

        //НЕЛЬЗЯ ОБРАЩАТЬСЯ К ГРУППЕ ИЗ САМОЙ СЕБЯ

        System.out.println("Именнованные группы");  // к именованным так же можно обращаться по их номеру
        System.out.println("11abc".replaceAll("(?<NameGroop>a)", "${NameGroop}-xyi-"));  // регу не из реги

        Pattern p3 = Pattern.compile("<(?<tag>[A-Z][A-Z0-9]*)[^>]*>.*?</\\k<tag>>");  // из реги регу
        Matcher m3 = p3.matcher("This is any <EM><I>first</I></EM> test with tags <P>second</P>");
        while (m3.find()){
            System.out.println(m3.start()  + " " + m3.group());
        }
        System.out.println("\n--------------------------------------\n");
    }
}
