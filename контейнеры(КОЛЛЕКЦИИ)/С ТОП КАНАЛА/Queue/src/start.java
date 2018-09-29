import java.util.*;

public class start{
    public static void main(String[] args){
        Queue queue1 = new LinkedList();  // очередь и 2-ухсвязный список
        // Упорядоченная очередь(элементы в порядке добавления)

        Queue queue2 = new PriorityQueue(); // онли очередь
        // отсортированная очередь(хранит отсортированные объекты)
        // Сортировка происходи после добавления каждого элемента(иногда выгоднее отсорт 1 раз путем преобра в лист и там Collections.sort(...))

        queue1.add("1");
        queue1.add("3");
        queue1.add("2");

        while(queue1.size() > 0){
            System.out.println(queue1.poll());
        }
    }
}

