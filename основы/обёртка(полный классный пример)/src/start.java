/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.Scanner;
        import java.util.Random;
        import java.util.EnumSet;

// НО ПРИ ПЕНРЕДАЧЕ ССЫЛОЧНОГО ТИПА В МЕТОД ЕСЛИ ЮЗАТЬ NEW ТО ИСХОДНОЕ ЗНАЧЕНИЕ НЕ ИЗМЕНИТСЯ
// САМА ССЫЛКА ПЕРЕДАЁТСЯ ПО ЗНАЧЕНИЮ!!!!
public class start {
    public static void main(String[] args) {
        obertka begin = new obertka();
        begin.Begin = new A();
        begin.Begin.a = 11;
        begin.Begin.b = 12;
        System.out.println(begin.Begin.a + "  " + begin.Begin.b);
        x(begin);
        System.out.println(begin.Begin.a + "  " + begin.Begin.b);
        System.out.println("\n");

        // теперь без обёртки
        A a = new A();
        a.a = 1;
        a.b = 2;
        System.out.println(a.a + "\t" + a.b);
        X(a);
        System.out.println(a.a + "\t" + a.b);
        XX(a);
        System.out.println(a.a + "\t" + a.b);
    }

    public static void X(A a){
        a.b = 111;
        a.a = 222;
        System.out.println(a.a + "\t" + a.b);
    }

    public static void XX(A a){
        a = new A();
        a.b = 666;
        a.a = 666;
        System.out.println(a.a + "\t" + a.b);
    }

    public static void x(obertka begin){
        begin.Begin = new A();
        begin.Begin.a = 234;
        begin.Begin.b = 6876;
        System.out.println(begin.Begin.a + "  " + begin.Begin.b);
    }

    private static class obertka{
        A Begin;
    }
}
