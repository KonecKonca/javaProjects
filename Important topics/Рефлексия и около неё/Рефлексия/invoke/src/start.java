import java.lang.reflect.*;

public class start {
    public static void main(String[] args) throws Exception{
        //Class foo = Class.forName("UnderTest");  // так тоже можно

        UnderTest test = new UnderTest();
        Class clazz = Class.forName(UnderTest.class.getName());  // параметр forname -- полное имя класса(включая пакеты)

        Method method0 = clazz.getDeclaredMethod("method0", null);
        method0.setAccessible(true);
        method0.invoke(test, null);

        Method method1 = clazz.getDeclaredMethod("method1", String.class);
        method1.setAccessible(true);
        method1.invoke(test, "XxXXXX");

        Method max = clazz.getDeclaredMethod("max", Integer.class, Integer.class);
        max.setAccessible(true);
        max.invoke(new UnderTest(), 8, 66);

        // ДЛЯ ВОЗВРАЩАЕМЫХ ЗНАЧЕНИЙ КРОМЕ ВОИД НУЖНО ЕЩЁ ПОДШАМАНИТЬ
    }
}

class UnderTest{
    private void method0(){
        System.out.println("HELLO WORLD!!!");
    }

    private static void method1(String str){
        System.out.println("method1 : " + str);
    }

    private void max(Integer n1, Integer n2){  // int не канает!!!
        if(n1 > n2){
            System.out.println(n1);
            return;
        }
        System.out.println(n2);
    }
}


