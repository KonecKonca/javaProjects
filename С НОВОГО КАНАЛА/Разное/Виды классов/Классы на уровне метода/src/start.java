import sun.applet.Main;

public class start{
    public static void main(String[] args)throws Exception{
        start s = new start();
        s.method();
    }

    void method(){
        // Нельзя создавать экземпы NewInner до его объявления
        class NewInner{
            void newMethod(){
                System.out.println("Класс на уровне метода");
            }
        }
        // Довольно ограниченые классы, редко используются

        NewInner newInner = new NewInner();
        newInner.newMethod();
    }
}







