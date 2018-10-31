import java.util.*;

public class MainClass {
    public static void main(String[] args)throws Exception {

        // ВСЕ ЭТИ КОЛЛЕКЦИИ НЕ ИЗМЕНЯЕМОГО РАЗМЕРА!!!
        List<Integer> list = List.of(1, 3, 54, 54,5, 4,43);
        //list.add(343);  // нельзя!!!
        System.out.println(list);

        Set<Integer> set = Set.of(1, 3, 54,5, 4,43);
        System.out.println(set);

        Map<String, String> map = Map.ofEntries(Map.entry("11", "111"), Map.entry("htfg", "222"));
        System.out.println(map);
    }
}
