import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MainClass {
    public static void main(String[] args) throws IOException {
        // Ковариантная запись
        Object[] objects = new String[5];

        // Инвариантная запись  (не скомпилируется)
        //ArrayList<Object> arrayList = new ArrayList<String>();

        // Так уже можно
        ArrayList<? extends Number> arrayList = new ArrayList<Integer>();  // ? из-за него(в отличии от массивов) мы хз, что с правой части
        // поэтому контейнер даётся только на чтение именно(arrayList)
        //arrayList.add(new Integer(4);   // так нельзя

        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(6);
        a.add(76);

        // Таким образом контейнер открывается только на чтение!!!

        arrayList = a;
        //arrayList.add(3);   // так нельзя


        ArrayList<? extends Integer> ref0 = null;
        ArrayList<? extends Number> ref1 = null;
        ref0 = ref1;
        ref1 = ref0;


        ArrayList<? super Integer> ref00 = null;
        ArrayList<? super Number> ref11 = null;
        ref00 = ref11;
        ref11 = ref00;

        /// Ещё раз подтверждение того что список работает только на чтение
        ArrayList<? extends A> aList = new ArrayList<B>();
        aList.add(new A());          // объект общего класса не канает
        aList.add(new B());     // но на месте B могбы быть и другой наследник A, т.е мы вообще хз и не можем добавлять объекты

        ArrayList<A> newList = new ArrayList<>();
        newList.add(new A());
        newList.add(new B());
    }
}

class A{}
class B extends A{}
