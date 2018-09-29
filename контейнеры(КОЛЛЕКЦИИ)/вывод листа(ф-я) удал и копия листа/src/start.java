/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.*;

public class start {
    public static void main(String[] args) {
        // массив символов и переадча его в список
        Character[] c = {'n', 'e', 'r', 'd'};
        List<Character> lst = Arrays.asList(c);
        System.out.println("Spisok");
        output(lst);
        // перестановка элементов списка
        System.out.println("Spisok after replacing");
        Collections.reverse(lst);
        output(lst);
        Character[] newC = new Character[c.length];
        List<Character> listCopy = new ArrayList(Arrays.asList(newC));
        Collections.copy(listCopy, lst);  // копирнуть в listCopy lst
        System.out.println("Copy");
        output(listCopy);
        System.out.println("После заполнения хернёй");
        Collections.fill(lst, 'O');  // заполнить весь список 'О'
        output(lst);
        delete(listCopy, 0);
        delete(listCopy, 0);
    }

    public static void output(List<Character> lst){
        for(Character c : lst){
            System.out.print(c + "\t");
        }
        System.out.println();
    }

    public static void delete(List<Character> lst, int nomber){
        System.out.println("После удаления");
        lst.remove(nomber);
        output(lst);
    }
}
