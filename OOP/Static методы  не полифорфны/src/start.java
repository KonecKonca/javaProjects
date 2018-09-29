import java.util.Arrays;
import java.util.Collections;

public class start {
    public static void main(String[] args) {
        B b = new B();
        b.method();
        B.method();

        A a = new B();
        a.method();  // для статкик методов и всех полей нет поличорфизма по подтипам
    }
}


class A{
    public static void method(){
        System.out.println("A");
    }
}


class B extends A{
    // @Override  ибо статика как и любые поля не оверрайдятся
    public static void method(){
        System.out.println("B");
    }
}
