/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.*;

// Обобщения работают только еа этапе компиляции
public class start {
    public static void main(String[] args) {
        //List<Child> listt = new ArrayList<Parent>(); такого быть не может
        // List<Child>[] arr = new ArrayList<Child>(); такое тоже не бывает
        // generici не могут быть статикой

        List<Parent> list = new ArrayList<>();
        list.add(new Parent());
        list.add(new Child());
        method(list);

    }

    static void method(List<? extends Parent> list){  // всё что наследуется от Parent
        for(Parent child : list){                      // Но есть ьограничение (МЫ НЕ МОЖЕМ ДОБАВИТЬ НОВЫЕ ЭЛЕМЕНТЫ, онли просмотор уже существубщих)
            System.out.println(child);
        }

        // Нельзя добавлять из-за того что можно кинуть 1-го наследника, а добавить другого, а они между собой вообще не кантачат
    }

    static void method2(List<?> list){  // то же что и extends object
        for(Object o : list){
            System.out.println(o);
        }
        // list.add(new Object()); тут тоже ничего нельзя добавлять
    }

    static void method3(List<? super Child> list){  // А приниваем всё что выще по иерархии
        for(Object o : list){                   // а всё что ниже по иерархии + можно добавлять
            System.out.println(o);
            Parent p = (Parent)o;
            p.x = 4444;
        }
        list.add(new Child());
        //list.add(new Object());  нельзя, т.к выще по иерархии
    }


}

class Parent{
    int x;
}

class Child extends Parent{

}