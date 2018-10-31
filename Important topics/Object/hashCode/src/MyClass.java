public class MyClass {
    private Integer id;
    private String name;

    public MyClass(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object){
        System.out.println("Equals is called" + this + " : " + object);
        MyClass other = (MyClass)object;
        return id.equals(other.id) && name.equals(other.name);
    }

    @Override
    public int hashCode(){  // переопред хеша
        System.out.println("Hash is called" + this);
        return id;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
