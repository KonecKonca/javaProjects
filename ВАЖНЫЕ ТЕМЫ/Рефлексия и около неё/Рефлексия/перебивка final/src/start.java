import java.lang.reflect.*;

public class start {
    public static void main(String[] args) throws Exception{
        UnderTest test = new UnderTest();

        System.out.println("До рефлекшина : " + test.getA());

        Field field = test.getClass().getDeclaredField("nomber");
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);  // хз зачем

        field.set(test, 666);
        System.out.println("После рефлецшина : " + field.get(test));  // если инициализ не через конструктор
    }                                                               // то нужно и вывод через рефлекшин
}

class UnderTest{
    private final int nomber = 1;  // Если сразу задать констапнтой(конкретное число), то нужно и вывод через рефлекшин
//    UnderTest(int n){           // т.к результат сразу будет подставлен в байт-код (в остальных случаях можно, но нет гарантий)
//        nomber = n;
//    }
    public int getA() {
        return nomber;
    }
}


