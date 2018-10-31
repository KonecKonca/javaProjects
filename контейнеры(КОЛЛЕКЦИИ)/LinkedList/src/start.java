/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.*;

public class start {
    public static void main(String[] args) {
        String[] zveri1 = {"Cat", "pinguin", "wolf", "ej", "dragon"};
        List<String> list1 = new LinkedList<String>();
        for(String str : zveri1){
            list1.add(str);
        }
        String[] zveri2 = {"ydav", "wolf", "Ej", "xyi"};
        List<String> list2 = new LinkedList<String>();
        for(String str : zveri2){
            list2.add(str);
        }
        list1.addAll(list2);
        list2 = null;

        printList(list1);
        removeFromList(list1, 1, 3);
        printList(list1);
        reverseList(list1);
        modifyList(list1);
        printList(list1);
    }

    private static void printList(List<String> lst){
        for(String str : lst){
            System.out.println("Название " + str);
        }
        System.out.println();
    }

    private static void removeFromList(List<String> lst, int start, int end){
        lst.subList(start, end).clear(); // подсписок(его удаление)
    }

    private static void reverseList(List<String> lst){
        ListIterator<String> iterator = lst.listIterator(lst.size());
        while (iterator.hasPrevious()){
            System.out.println("Название " + iterator.previous());
        }
        System.out.println();
    }

    public static void modifyList(List<String> list){
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            list.set(iterator.nextIndex(),"Я - " + iterator.next()); // изменение уже существующих
    }
    }
}
