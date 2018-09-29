import java.io.FileInputStream;
import java.lang.reflect.*;

public class start {
    public static void main(String[] args) throws Exception{
        ReflectionCheaker cheaker = new ReflectionCheaker();
        Rabbit rabbit = new Rabbit();

//        cheaker.showClassName(rabbit);

//        cheaker.showClassFields(rabbit);

//        cheaker.showClassMethods(rabbit);  // все можно прочекать поочереди

//        cheaker.showFieldsAnnotations(rabbit);

//        change(rabbit, cheaker);

        Object rabbit2 = cheaker.createNewObject(rabbit);
        ((Rabbit)rabbit2).anyMethod();

    }

    public static void change(Rabbit rabbit, ReflectionCheaker cheaker) throws IllegalAccessException {
        System.out.println(rabbit.getAge());
        System.out.println(rabbit.getWeight());
        System.out.println(rabbit.getName());

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
        cheaker.fillRabbitAnnotationFields(rabbit);

        System.out.println(rabbit.getAge());
        System.out.println(rabbit.getWeight());
        System.out.println(rabbit.getName());
    }
}
