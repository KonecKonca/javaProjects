package base.xml;

public class Owner {
    private String name;
    private String sourName;
    private int age;
    private Profession profession;


    public Owner() {
    }
    public Owner(String name, String sourName) {
        this.name = name;
        this.sourName = sourName;
    }
    public Owner(String name, String sourName, int age, Profession profession) {
        this.name = name;
        this.sourName = sourName;
        this.age = age;
        this.profession = profession;
    }

    public void init(){
        System.out.println("            Owner init method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourName() {
        return sourName;
    }

    public void setSourName(String sourName) {
        this.sourName = sourName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", sourName='" + sourName + '\'' +
                ", age=" + age +
                ", profession=" + profession +
                '}';
    }
}
