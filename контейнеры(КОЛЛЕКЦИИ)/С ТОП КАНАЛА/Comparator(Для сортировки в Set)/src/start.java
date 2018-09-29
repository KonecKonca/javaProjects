import java.util.*;

class Person implements Comparable<Person>{
    int age;
    public Person (int age){
        this.age = age;
    }

    @Override  // без этого метода прога не запустится
    public  int compareTo(Person p){  // метод для сравнения
        return this.age - p.age;  // для сортировки по возрасту
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

class CompareCar implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2){
        return o1.speed - o2.speed;
    }
}

class Car{
    int speed;

    public Car(int speed){
        this.speed = speed;
    }
}

public class start{
    public static void main(String[] args){
        Set<Person>  set = new TreeSet<>();   //  сортируется по умолчанию
        set.add(new Person(4));
        set.add(new Person(6));
        set.add(new Person(4));
        set.add(new Person(2));
        for(Person i : set){
            System.out.println(i);
        }
        System.out.println();

        // Но если класс PErson  не наш, и мы не можем его править...
        CompareCar compareCar = new CompareCar();
        Set<Car> setCars = new TreeSet<>(compareCar);
        setCars.add(new Car(45));
        setCars.add(new Car(15));
        setCars.add(new Car(325));
        setCars.add(new Car(35));
        for(Car c : setCars){
            System.out.println(c.speed);
        }
    }
}

