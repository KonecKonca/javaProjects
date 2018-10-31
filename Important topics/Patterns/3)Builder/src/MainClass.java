public class MainClass {
    public static void main(String[] args) {
        SportCar car1 = new SportCar.Builder("Mazda 6").setColor("Red").setAge(1).setMaxSpeed(240).build();
        SportCar car2 = new SportCar.Builder("Minsk D4").setColor("Red").setAge(2).setMaxSpeed(110).build();
        System.out.println(car1);
        System.out.println(car2);

        //// Отступление от паттерна
        SportCar car3 = new SportCar().setAge(45).setName("Alesha");
        System.out.println(car3);
        //// Отступление от паттерна
    }
}

class SportCar{
    //// Отступление от паттерна
    public SportCar setAge(int age){
        this.age = age;
        return this;
    }
    public SportCar setName(String name){
        this.name = name;
        return this;
    }
    public SportCar(){}
    //// Отступление от паттерна

    private String name;
    private String color;
    private int maxSpeed;
    private int age;
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "SpotCar{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", age=" + age +
                '}';
    }

    private SportCar(Builder builder){
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
        this.age = builder.age;
    }
    static class Builder{
        private String name;
        private String color;
        private int maxSpeed;
        private int age;

        public Builder(String name) {  // в конструкторе только обязательные поля
            this.name = name;
        }
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }
        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public SportCar build(){
            return new SportCar(this);
        }
    }
}