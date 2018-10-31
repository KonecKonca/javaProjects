/**
 * Created by Андрей on 31.12.2017.
 */

import java.lang.reflect.Array;
import java.util.*;

public class start {
    public static void main(String[] args) {
        PriorityQueue<Integer> g = new PriorityQueue<Integer>();
        g.offer(1);
        g.offer(2);
        g.offer(3); // можно g.add(), различия в обработке ошибок
        System.out.print(g + "\t");
        System.out.println();
        System.out.print(g.peek() +"\t");  // вывлд 1-го без удаления его из очереди
        System.out.println();
        g.poll();  // убрать 1-ый из очереди
        System.out.println(g + "\t");
        System.out.println();
        g.offer(4);
        g.offer(5);
        System.out.println(g.size());
    }

}
