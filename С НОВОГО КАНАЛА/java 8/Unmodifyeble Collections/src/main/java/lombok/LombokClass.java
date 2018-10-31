package lombok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LombokClass {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("one", "two", "three", "6"));

        List<String> unmodifyible = Collections.unmodifiableList(arrayList);
        for(String str : unmodifyible){
            System.out.println(str);
        }

        unmodifyible.add("dfeff");
    }
}
