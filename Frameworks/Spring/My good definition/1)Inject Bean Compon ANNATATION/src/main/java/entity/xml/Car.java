package entity.xml;

import java.util.List;

public class Car extends AbstractCar{
    private String name;
    private int age;
    private Owner owner;
    private List<String> models;

    public Car() {
    }

    public Car(String name, int age, Owner owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public void carMethod(){
        System.out.println("Not util (CAR)");
    }
    @Override
    public String getModel() {
        return "Model of car: " + models;
    }

    public void setModels(List<String> models) {
        this.models = models;
    }
    public void setModel(List<String> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", owner=" + owner +
                ", models=" + models +
                '}';
    }
}
