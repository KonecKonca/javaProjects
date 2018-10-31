import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class start{
    public static void main(String[] args) {
        String str1 = "Message1 -- {0}  and  Message2 -- {1}";   // можно просто так ставить метки (можно с типом данных типо {1, number})
        String str2 = MessageFormat.format(str1, "1111", "22222");

        System.out.println(str1);
        System.out.println(str2);
    }
}

