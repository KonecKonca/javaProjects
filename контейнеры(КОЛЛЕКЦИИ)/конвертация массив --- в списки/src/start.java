/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.*;

public class start {
    public static void main(String[] args) {
        String[] mass = {"1", "2", "3", "4", "5"};
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(mass)); // добавление в лист всего массива

        list.add("6");
        list.addFirst("0");

        mass = list.toArray(new String[list.size()]); // список в массив

        for (String str : mass){
            System.out.println(str);
        }
    }
}
