import java.util.*;

public class start{
    public static void main(String[] args){
        // Так же как и map(но вообще это и есть map), только в которой не повторяются значения
        // т.к объект кидается в map как ключ(а в map не может быть одинаковых ключей)

        Set set = new HashSet();// не упорядоченная
        // использует HashMap

        Set set2 = new LinkedHashSet(); // (упорядоченная)в порядке ввода
        // использует LinkedHashMap

        Set set3 = new TreeSet(); // отсортированная
        // использует TreeMap

        set.add("1");
        set.add("2");
        set.add("2");
        set.add("3");
        set.add("1");
        set.add("1");

        for(Object o : set){
            System.out.println(o);
        }
    }
}

