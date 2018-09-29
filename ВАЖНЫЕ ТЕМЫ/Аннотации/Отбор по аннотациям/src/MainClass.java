import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class MainClass {
    public static void main(String[] args) throws IllegalAccessException{
        MainClass mainClass = new MainClass();
        Person person = new Person();
        mainClass.print(person, person.getClass());
    }

    public void print(Object o, Class c) throws IllegalAccessException {
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields){
            Annotation[] annotations = field.getDeclaredAnnotations();
            for(Annotation annotation : annotations){
                if(annotation.annotationType().equals(Show.class)){
                    System.out.println(field.get(o));
                }
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)  // чтоб была видна при запуске
@interface Show{
}

class Person{
    @Show
    String name = "Andrei";
    int age = 24;
}
