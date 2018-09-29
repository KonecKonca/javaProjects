/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.*;

public class start {
    public static void main(String[] args) {
        Integer[] numbers = {34, 35, 436, 3531, 757, 57 ,4};
        List<Integer> list = Arrays.asList(numbers);

        System.out.println(list + "\n");

        Collections.sort(list);  // сортировка по возрастанию
        System.out.println(list + "\n");

        Collections.sort(list, Collections.reverseOrder()); // сортировка по убыванию
        System.out.println(list + "\n");
    }
}
