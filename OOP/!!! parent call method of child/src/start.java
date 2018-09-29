
// при вызове method1 происходит следующее
// его нет в наследнике, так что ищем в паренте
// потов в самом методе вызывается metho2, которого уже нет в паренте
// и мы берём его в наследнике

// Таким образом получается проход в обе стороны

public class start {
    public static void main(String[] args) {
        Child child = new Child();
        child.method1();
        System.out.println("\n");

        Parent child2 = new Child();
        child2.method1();
    }
}


abstract class Parent{
    public void method1(){
        System.out.println("method1 Parent");
        metho2();
    }
    public abstract void metho2();
}

class Child extends Parent{

    @Override
    public void metho2(){
        System.out.println("Method2 Child");
    }
}


