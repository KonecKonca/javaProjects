public class StartClass {
    public static void main(String[] args){
        Inter inter = (e1, e2) -> "Name " + e1 + ", age: " + e2; // однострочные можно без ретурна
        System.out.println(inter.function("Andrei", 18));
        System.out.println();

        anyDo.done((e1, e2) -> e1 + " " + e2, 18, "Vasia");
    }
}

class anyDo{
     static void done(Inter in, int age, String name){
         System.out.println(in.function(name, age));
     }
}

interface Inter{
     String function(String name, int age);
}
