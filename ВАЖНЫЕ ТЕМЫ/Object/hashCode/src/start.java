import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class start{
    public static void main(String[] args) throws Exception{
        MyClass m1 = new MyClass(11, "name1");
        MyClass m2 = new MyClass(12, "name2");

        /*if(m1.equals(m2)){
            System.out.println("ok");
            System.out.println(m1.hashCode());
            System.out.println(m2.hashCode() + "\n\n");
        }*/

        Set<MyClass> set = new HashSet<>();
        System.out.print("1)  ");
        set.add(m1); // вызывается хешкод (при добавке в set) ЕСЛИ ЕСТЬ ДР ОБЪ-ТЫ  C ТЕМ ЖЕ ХЕШЕМ ВЫЗ-ТСЯ EGUALS ДЯЛ СРАНН С КАЖДЫМ
        System.out.print("2)  ");
        set.add(m2);
        System.out.print("3)  ");
        set.add(new MyClass(13,"name3"));
        System.out.print("4)  ");
        set.add(new MyClass(11,"name1"));
        System.out.println("Уникальных объектов :" + set.size());  /// т.е в сете 2 лдниаковых объекта, НО ЭТО ЖЕ СЕТ

        // в первую очередь проверятся ХЕШ(если есть объекты с одинаковыми хешами,
        // то они сравниваются equals-ом)

        // Коллекция(типа Set) сама сразу проверяет hasCode на различие

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // Сравнение объектов дорогая процедура(много полей) -->
        // сначала сравнивается hashCode(1 поле), если он разный, то и объекты разные,
        // если однинаковый, то вызываем eguals, кторый уже сравнивает всё поля и даёт однозначный ответ
        // hash отсеивает точно разные объекты

    }
}
