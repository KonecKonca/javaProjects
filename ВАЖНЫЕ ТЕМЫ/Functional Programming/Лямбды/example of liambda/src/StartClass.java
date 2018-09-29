public class StartClass {
    public static void main(String[] args){
        Inter inter = (e1, e2) ->{
            System.out.println("Name " + e1 + ", age: " + e2);
            return 5;
        };
        System.out.println(inter.function("Andrei", 18));

        InterWithGeneric<Double, Integer, String> interWithGeneric = (e1, e2, e3) ->{
            String str = "Result of liambda: ";
            str += e1 + " " + e2 + " " + e3;
            return str;
        };
        System.out.println(interWithGeneric.function(4.5, 53, "abcd"));


//        anyDo anyDo = new anyDo();
//        anyDo.done(inter, 32);
    }
}

class anyDo{
     void done(Inter in, int age){

     }
}

interface Inter{
     int function(String name, int age);
}

interface InterWithGeneric <T1, T2, T3> {
    String function(T1 t1, T2 t2, T3 t3);
}