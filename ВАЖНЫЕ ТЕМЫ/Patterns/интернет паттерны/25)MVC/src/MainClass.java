import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.omg.CORBA.portable.ValueInputStream;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        Controller controller = new Controller();
        controller.execute();
    }
}

// типо данные из БД
class Student{
    private String name = "Andrei";
    private int age = 56;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

interface ModelLayer{
    Student getStudent();
}
class DBLayer implements ModelLayer{
    @Override
    public Student getStudent() {
        return new Student();
    }
}
class FileSystemLayer implements ModelLayer{
    @Override
    public Student getStudent() {
        return new Student();
    }
}

interface View{
    void showStudent(Student student);
}
class ConsoleView implements View{
    @Override
    public void showStudent(Student student) {
        System.out.println("Student Name: " + student.getName() + "; age: " + student.getAge());
    }
}

class Controller{
    private ModelLayer modelLayer = new DBLayer();
    private View view = new ConsoleView();

    void execute(){
        Student student = modelLayer.getStudent();
        view.showStudent(student);
    }
}