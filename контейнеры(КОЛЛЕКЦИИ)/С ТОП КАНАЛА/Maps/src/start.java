import java.util.*;

public class start{
    public static void main(String[] args){
        // Всё это коллекции по типу ключ значение
        // Есть класс Node хранящий значение, ключ и ссылку на некст(не гарантии что по порядку)
        // Также есть массив из Node(в нём всё хранится)

        Map map = new HashMap();
        //  Содержит Hash в Node, не упорядоченный список
        // Прикол это таблицы в том что мы по хешу находим номер объекта в таблице
        // Если есть объекты с одинаковыми хешами, то через next храним через связный список

        Map map2 = new Hashtable();
        // То же что и HashMap, но все методы synxronysed

        Map map3 = new LinkedHashMap();
        // В отличии от предидущих все значения хранятся в порядке ввода

        Map map4 = new TreeMap();
        // Ебучее красно-чёрное дерево, т.е список отсортиррованный

        map.put("1", "one");
        map.put("3", "three");
        map.put("2", "two");
        map.put(3, "Xrenь");
        System.out.println(map.get(3));
    }
}

