
public class StartClass{
    public static void main(String[] args){   // ссылка на кконструктор в оболочке функ интерфейса
        UserBuilder userBuilder = User::new;  // конструктор по дефолту возращает объект данного класса
        User user = userBuilder.create("Vasil");
        System.out.println(user.getName());

        UserBuilder userBuilder2 = User::createUser;  // для не статического нужно было бы указывать объект типа User
        User user2 = userBuilder2.create("Andrei");
        System.out.println(user2.getName());
    }
}

@FunctionalInterface
interface UserBuilder {
    User create(String name);
}

class User{
    private String name;
    String getName(){
        return name;
    }

    User(String name){
        this.name = name;
    }

    static User createUser(String name){
        return new User(name);
    }
}