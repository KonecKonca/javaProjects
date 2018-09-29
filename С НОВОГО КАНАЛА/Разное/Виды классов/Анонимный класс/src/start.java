import sun.applet.Main;

public class start{
    public static void main(String[] args)throws Exception{
        Popcorn popcorn = new Popcorn(){  // вместо (;) ---> ({}) т.е в фиг. скобках создается новый класс(наследуемый от Popcorna) и он может переопред классы и интерфейсы
            void doSomthing(){
                System.out.println("main");
            }

            void second(){
                System.out.println("second"); // нельзя вызвать так popcorn.second();
            }       // хз можно ли так писать
        };
        // по сути это безименный класс
        popcorn.doSomthing();
        popcorn.first();

        // Мы создали объект интерыейса!!!??7!1?!?
        // На самом деле мы создали класс наслед. и реализ интерфейс и кмнули его адресс в ссылку на интерфейс
        Comparable comparable = new Comparable(){
            @Override
            public int compareTo(Object o){
                return 0;
            }
        };

        // А теперь ебнем как параметр аонимный класс
        method(new Popcorn(){
            void doSomthing(){
                System.out.println("Ебать, мы переопределили");
            }
        });
    }

    static void method(Popcorn popcorn){
        popcorn.doSomthing();
    }
}

class Popcorn{
    void doSomthing(){
        System.out.println("popcorn");
    }
    void first(){
        System.out.println("first");
    }
}







