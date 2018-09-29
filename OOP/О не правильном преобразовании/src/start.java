
// нИСХОДЯЩЕЕ ПРЕОБРАЗОВАНИЕ ЕСТЬ КОГДА МЫ НАСЛЕДНИКА КИНУЛИ В ТИП ПАРЕНТА, А ПОТОМ ВЕРНУЛИ ОБРАТНО!!!!

public class start {
    public static void main(String[] args) {
        Parent x = new Child();
        //  x.newmethod(); // нет такого метода у данного объекта


        Parent parent = new Parent();
        // насильно захуярили
        Child child;
        try {
            child = (Child) parent;
            // но по факту объекты не идентичны и вылетит exception (ТАК ВПРИНЦИПЕ ДЕЛАТЬ НЕЛЬЗЯ)

            // Тут можно, но нет толку, т.к вылетит исключение
            child.newmethod();
            child.method();
        }
        catch (Exception ex){
            System.out.println("!!!!");
        }

//        child.newmethod();  // оба метода недоступны
//        child.method();
    }
}

class Parent{
    void method(){
        System.out.println("Parent");
    }
}

class Child extends Parent{
    void newmethod(){
        System.out.println("Child");
    }
}
