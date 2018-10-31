

// Рефлексия позволяет залезьте в класс и получить доступ к недоступным полям и методам\
// ЗАпуск приватных методов
// изменение приватных полей

import java.io.FileInputStream;
import java.lang.reflect.*;

public class start {
    public static void main(String[] args) throws Exception{
        SomeClass someClass = new SomeClass();
        Class clss = someClass.getClass();
        System.out.println("Name of the class: " + clss.getName() + "\n");

        // Альтернативные вариации для получения класса
//        Class clss2 = SomeClass.class;
//        Class clss3 = Class.forName("SomeClass"); // путь после src типа (a.b.MainClass)
//        SomeClass someClass1 = (SomeClass)clss.newInstance();  // то же что и с new

        System.out.println("Constructors:");
        Constructor[] constructors = clss.getDeclaredConstructors(); // getMethod - все доступные методы ; getDeclaredMethod - вообще все методы(private тоже)
        for(Constructor constructor : constructors){
            System.out.println("Name of constructor: " + constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for(Parameter parameter : parameters){
                System.out.println("Parametres: " + parameter.getName());
                System.out.println(parameter.getType().getName());
            }
        }

        System.out.println("\nMethods");
        Method[] methods = clss.getDeclaredMethods();
        for(Method method : methods){
            System.out.println("Name of the method " + method.getName());
            Parameter[] parameters = method.getParameters();
            for(Parameter parameter : parameters){
                System.out.println("Parametres: " + parameter.getName());
                System.out.println(parameter.getType().getName());
            }
            System.out.println("MOdificators of metod: " + Modifier.toString(method.getModifiers()));
            System.out.println("Type of retriew value: " + method.getReturnType().getName());
            method.setAccessible(true);
            method.invoke(someClass, "test"); // Запуск метода
        }

        System.out.println("\n Fields");
        Field[] fields = clss.getDeclaredFields();
        for(Field field : fields){
            System.out.println("Name: " + field.getName());
            System.out.println("Type: " + field.getType().getName());
            System.out.println("Modifaers: " + Modifier.toString(field.getModifiers()));

            field.setAccessible(true); // Для приватов без этого след строка(выдаст ошибку)
            System.out.println(field.getInt(someClass));
            field.setInt(someClass, 5);
            System.out.println(field.getInt(someClass));
        }
    }
}

// допустим что этот класс лежит в библиотеке(мы не можем его править(нет доступа)),
class  SomeClass{
    private static transient int i;
    //String s;

    public SomeClass(){}
    public SomeClass(String s){
        //this.s = s;
    }
    private synchronized String someMethod(String str){
        System.out.println("Zapysk methoda classa \\\\ " + str);
        return str;
    }
}
