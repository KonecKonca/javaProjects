import java.io.IOException;

public class start {
    public static void main(String[] args) {

        Child child = new Child();
        child.method1();

        Parent parent = new Parent();
        parent.method1();  // нужно отловить ехцептион

        Child2 child2 = new Child2();
        child2.method1();  // нужно отловить ехцептион
    }
}

 class Parent{
    public void method1() throws Exception{
        System.out.println("method1 Parent");
    }
}

class Child extends Parent{
    @Override
    public void method1(){
        System.out.println("Method2 Child");
    }
}

class Child2 extends Parent{
    @Override
    public void method1() throws IOException{
        System.out.println("Method2 Child2");
    }