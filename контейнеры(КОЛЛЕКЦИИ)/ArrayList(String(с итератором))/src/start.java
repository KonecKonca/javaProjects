/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.*;

public class start {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        Scanner vvod = new Scanner(System.in);
        System.out.println("Введи длину списка");
        int len = vvod.nextInt();
        for (int i = 0; i < len; i++) {
            System.out.println("№" + (i + 1) + " Введи имя");
            list1.add(vvod.next());
        }

        ArrayList<String> list2 = new ArrayList<String>();
        System.out.println("Введи длину списка");
        len = vvod.nextInt();
        for (int i = 0; i < len; i++) {
            System.out.println("№" + (i + 1) + " Введи имя");
            list2.add(vvod.next());
        }

        for (int i = 0; i < list1.size(); i++) {
            System.out.println("Имя: " + list1.get(i));
        }
        System.out.println("//////////////////////////////////////////////////");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println("Имя: " + list2.get(i));
        }
        System.out.println("//////////////////////////////////////////////////");
        editList(list1, list2);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("Имя: " + list1.get(i));
        }
    }

    public static void editList(ArrayList<String> lst1, ArrayList<String> lst2){
            ListIterator<String> iterator = lst1.listIterator();
            while (iterator.hasNext()){
                if(lst2.contains(iterator.next())){   //lst1.get(i) == lst2.get(j)  так писать нельзя
                    iterator.remove();  //удаление повторяющихся элементов
                                        // так тоже нельзя lst1.add("dfgsg");
                                        // в случае совпадения выдаст ошибку
                    iterator.add("XxXxXxXxX");
                }
            }
    }
}
