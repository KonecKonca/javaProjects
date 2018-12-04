package pack2;

public class Test {

    public static void main(String[] args) {

//        Interf a = new Klass();
//        a.x1();
//        a.x2();
//        a.method1();
//        a.method2();
//
//        Abstract b = new Klass();
//        b.x1();
//        b.x2();
//        b.method1();
//        b.method2();

    }

}

interface Interf{
    void x1();
}
abstract class Abstract{

    abstract void x2();

}

class Klass extends Abstract implements Interf{

    @Override
    public void x1() {
        System.out.println("Method x1");
    }
    @Override
    void x2() {
        System.out.println("Method x2");
    }

    public void method1(){
        System.out.println("method1");
    }


    public static void method2(){
        System.out.println("method2");
    }
}
