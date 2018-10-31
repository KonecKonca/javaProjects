import javax.jws.soap.SOAPBinding;
import java.io.*;

public class start{
    public static void main(String[] args) throws Exception{
        UserChild user = new UserChild();
        user.healthpoints = 100;
        user.staticField = 666;
        Mech newMech = new Mech();
        newMech.level = 5;
        user.mech1 = newMech;
        user.mech2 = newMech;
        user.childinfa = 101;

        FileOutputStream fileOutputStream = new FileOutputStream("tempFile");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);  // запись(сериализация)
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        user.staticField = 555;
        user.healthpoints = 1430;
        user.childinfa = 303;

        FileInputStream fileInputStream = new FileInputStream("tempFile");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);  // ввод(десириализация)
        UserChild newUser = (UserChild) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(newUser.healthpoints);
        System.out.println("Статика не записывается  " + newUser.staticField); // вывод значение не из бинарника
        System.out.println(newUser.mech1.level);
        System.out.println("Транзиенты не записываются " + newUser.mech2);
        System.out.println("Новое поле наследника  " + newUser.childinfa);
    }
}
