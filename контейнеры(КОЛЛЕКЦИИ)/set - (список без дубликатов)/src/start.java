/**
 * Created by Андрей on 31.12.2017.
 */

import java.lang.reflect.Array;
import java.util.*;

public class start {
    public static void main(String[] args) {
        String[] brands = {"Intel", "Core","Dell", "Apple", "IBM", "LG", "Dell"};
        List<String> brandsList = Arrays.asList(brands);
        System.out.println(brandsList + "\n");
        Set<String> set = new HashSet<String>(brandsList); // создани на основе списка
        System.out.println(set);  // хешсет не принимает дубликаты
        set.add("intel");
        set.add("Dell");
        set.add("Apple");
        set.add("gogle");
        System.out.println(set);
        System.out.println(set.size());
    }

}
