import com.google.common.collect.*;
import org.testng.annotations.Test;

import java.awt.font.MultipleMaster;
import java.util.ArrayList;
import java.util.HashSet;

public class CustomCollections {

    @Test
    public void mutableList(){

        ArrayList<String> list = Lists.newArrayList("first", "second", "third");
        HashSet<String> set = Sets.newHashSet("4", "5", "6");

        Iterable<String> iterable = Iterables.concat(list, set);
        System.out.println(iterable);

        Iterable<String> iterableSkip = Iterables.skip(iterable, 2);
        System.out.println(iterableSkip);

        Iterable<String> iterableLim = Iterables.limit(iterable, 5);
        System.out.println(iterableLim);

    }

    @Test
    public void sets(){

        HashSet<Integer> set1 = Sets.newHashSet(1, 2, 3, 4 ,5);
        HashSet<Integer> set2 = Sets.newHashSet(4, 5, 6 , 7);

        System.out.println(Sets.difference(set1, set2));
        System.out.println(Sets.difference(set2, set1));
        System.out.println(Sets.intersection(set1, set2));

    }

    @Test
    public void multiSet(){
        HashMultiset<Object> multiset = HashMultiset.create();

        multiset.add("letscode");
        multiset.add("razbor poletov", 3);
        multiset.add("radio");
        multiset.add("radio");

        System.out.println(multiset);

    }

    @Test
    public void multiMap(){
        HashMultimap<String, String> multimap = HashMultimap.create();

        multimap.put("letsCode", "Dru");
        multimap.put("1", "city");
        multimap.put("1", "socite");
        multimap.put("2", "A");
        multimap.put("2", "B");

        System.out.println(multimap);

    }

    @Test
    public void biMap(){
        HashBiMap<String, String> biMap = HashBiMap.create();

        biMap.put("1", "A");
        biMap.put("2", "B");
        biMap.put("3", "C");

        System.out.println(biMap);
        System.out.println(biMap.get("1"));
        System.out.println(biMap.inverse().get("A"));

    }

    @Test
    public void table(){
        HashBasedTable<String, String, Double> table = HashBasedTable.create();

        table.put("Mike", "2017-11-15", 3000d);
        table.put("Mike", "2017-10-15", 1000d);
        table.put("VAsil", "2017-11-15", 1500d);
        table.put("Ibragim", "2017-10-15", 2000d);
        table.put("Ibragim", "2017-11-15", 1000d);

        System.out.println(table);
        System.out.println(table.get("Mike", "2017-11-15"));
        System.out.println(table.row("Mike"));
        System.out.println(table.column("2017-11-15"));

        System.out.println("\n" +Tables.transpose(table));

    }

}
