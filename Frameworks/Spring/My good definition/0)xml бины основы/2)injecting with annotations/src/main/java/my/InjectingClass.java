package my;

import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class InjectingClass {
    private String name;
    private String age;
    private List<String> nombers;

    public InjectingClass(){
        System.out.println("Injecting class is Created");
    }
    public InjectingClass(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void action(){
        System.out.println("My name is " + name + " I am " + age + " years old!!))");
        System.out.println("My favoutite nombers: " + nombers.toString());
    }

    @Required
    public List<String> getNombers() {
        return nombers;
    }
    @Required
    public void setNombers(List<String> nombers) {
        System.out.println("Setter is called (InjectingClass.setNombers())");
        this.nombers = nombers;
    }
    public String getName() {
        return name;
    }
    @Required    // некая страховка, проверяющая засетали ли поле через xml (нет -> exception)
    public void setName(String name) {
        System.out.println("Setter is called (InjectingClass.setName())");
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    @Required
    public void setAge(String age) {
        System.out.println("Setter is called (InjectingClass.setAge())");
        this.age = age;
    }
}
