import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionCheaker {

    public void showClassName(Object object){
        Class clazz = object.getClass();
        System.out.println(clazz.getName());  // Если лежит в пакеты, то имя быдет выводится с пакетом
    }

    public void showClassFields(Object object){
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();  // без декларед приваты не выдаст (а так все и приват и паблик)
        System.out.print("Поля в классе : " );
        for(Field field : fields){
            System.out.print(field.getName() + ", ");
        }
        System.out.println();
    }
    public void showClassMethods(Object object){
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();  // так онли паблики (а с декларед онли приваты (protected тоже к приватам))
        System.out.print("Методы в классе : " );
        for(Method method : methods){
            System.out.print(method.getName() + ", ");
        }
        System.out.println();
    }
    public void showFieldsAnnotations(Object object){
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Все поля с их аннотациями");
        for(Field field : fields){
            System.out.print("Метод " + field.getName() + ": ");
            Annotation[] annotations = field.getAnnotations();
            for(Annotation annotation : annotations){
                System.out.print(annotation + ", ");
            }
            System.out.println();
        }
    }
    public void fillRabbitAnnotationFields(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            Annotation annotation = field.getAnnotation(RabbitAnnotation.class);  // если в field не будет самодельн аннот, то в annotation будет null
            if (annotation != null){
                field.setAccessible(true);  // ЭТИМ МЫ ХЕРИМ ПРИВАТНОСТЬ ПОЛЯ!!! (без этого нихуя не выйдет) (кстати рпи не выполнении и вылетело бы искл)
                field.set(object, 666);  // куда, и на что меняем
            }
        }
    }
    // Для создания через рефлексию (в разы медленне чем через new)
    public Object createNewObject(Object object) throws IllegalAccessException, InstantiationException {
        Class clazz = object.getClass();
        return clazz.newInstance();  // из-за этого исключения (т.к наличие параметров в конструкторе мы не предусмотрели)
                                      // + конструктор может быть приватным
        // По сути по исходному объекту глянули его тип(класс)
        // и создали новый объект такого же типа(класса)
    }

}
