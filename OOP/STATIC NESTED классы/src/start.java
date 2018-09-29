
public class start {
    public static void main(String[] args) {

        // Для статики объемлющий класс не нужен
        X.Nested nested = new X.Nested();  // экземпляр X не создаётся!!!!!!!!!!
        //nested.x();
        Y y = new Y();
        y.y(nested);
    }
}

class X{
    private int z = 666;

    private static int c = 0;

    public X(){
        System.out.println("ОБъект X создан");   // чекать момент создания X
    }

    // без создания экземпа видит статику класса X
    static class Nested{
        public void x(){
            System.out.println("XXX");
            //System.out.println(z);  //если z static то строка сработала бы
            X xxx = new X();
            xxx.z = 101;
            System.out.println(xxx.z);  //  статик нестеды видят приваты объемлющего класса (через созданный объект объемлющего класса)
            c = 232;
        }
    }
}

class Y{
    public void y(X.Nested nested){
        nested.x();
    }
}


