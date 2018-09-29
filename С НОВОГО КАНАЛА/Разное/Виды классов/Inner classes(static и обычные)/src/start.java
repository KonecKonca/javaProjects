import sun.applet.Main;

public class start{
    private int i = 5;
    private static int q = 5;

    Inner inner3 = new Inner();

    public static void main(String[] args)throws Exception{
        start s = new start();
        s.method();
        Inner inner2 = s.new Inner();  // просто создать объект иннре класса нельзя из-за статики
        inner2.method2();

        StaticClass staticClass = new StaticClass();
        staticClass.mthod();
        StaticClass.mthod();
    }

    void method(){
        Inner inner = new Inner();
        inner.method2();
        System.out.println(inner.k);
        inner3.method2();
    }

    /*private*/class Inner{
        int k = 6;
        void method2(){
            System.out.println(i + "\n");
        }
    }

    static class StaticClass{ // !!! ФРАЗА "СТАТИЧЕСКИЙ ВНУТРЕННИЙ КЛАСС" - лажа, класс просто статический
        static void mthod(){
            //System.out.println(i);  нельзя
            System.out.println("Пошла статика " + q);
        }
    }
}

class Second{
    void met(){
        start.Inner inner = new start().new Inner();  // Если будет приват, то строка не срабоатает
        // т.е без создания экземпляра внешнего класса мы не можем создать экземпляр внутреннего
        inner.method2();

//        start.StaticClass staticClass = new start.StaticClass();
//        staticClass.mthod();   // " Это всё ок работает (но опять же невозможно создание внутр. класса без создания внешнего класса)
    }
}






