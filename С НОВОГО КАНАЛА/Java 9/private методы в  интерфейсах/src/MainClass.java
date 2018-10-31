public class MainClass {
    public static void main(String[] args)throws Exception {
        A a = new A(){};
        a.printMessage("Hello world");
    }
}

interface A{
    private void print(String s){
        System.out.println(s);
    }

    default void printMessage(String s){
        print(s);
    }
}

