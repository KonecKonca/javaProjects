import com.sun.org.apache.xpath.internal.operations.Operation;

public class StartClass{
    public static void main(String[] args){
        Oper func1 = action(1);
        int a1 = func1.result(3, 5);
        System.out.println(a1);

        Oper func2 = action(2);
        int a2 = func2.result(3, 5);
        System.out.println(a2);

        Oper func3 = action(3);
        int a3 = func3.result(3, 5);
        System.out.println(a3);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ////////////////////////////////////////
        MyltiOper func4 = superAction(1);
        int a4 = func4.result(1, 5, 5,5);
        System.out.println(a4);

        MyltiOper func5 = superAction(2);
        int a5 = func5.result(1, 5, 5,5);
        System.out.println(a5);
    }

    private static Oper action(int nomber){
        switch(nomber){
            case 1: return (x, y) -> x + y;
            case 2: return (x, y) -> x - y;
            case 3: return (x, y) -> x*y;
            default: return (x, y) -> 0;
        }
    }

    private static MyltiOper superAction(int nomber){
        switch(nomber){
            case 1: return (int ... e) -> {
                int res = 0;
                for(int i : e){
                    res += i;
                }
                return res;
            };
            case 2: return (int ... e) ->{
                int res = 1;
                for(int i : e){
                    res *= i;
                }
                return res;
            };
            default: return (int ... e) -> 0;
        }
    }

}

@FunctionalInterface
interface Oper{
    int result(int n1, int n2);
}

@FunctionalInterface
interface MyltiOper{
    int result(int ... n);
}
