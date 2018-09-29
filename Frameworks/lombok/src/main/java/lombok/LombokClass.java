package lombok;

import java.util.Date;

public class LombokClass {
    public static void main(String[] args) {
        System.out.println("Old dissision: ");
        UserWithoutLombok userWithoutLombok = new UserWithoutLombok();
        userWithoutLombok.setActive(true);
        userWithoutLombok.setAge(22);
        userWithoutLombok.setDate(new Date());
        userWithoutLombok.setLastNale("XXXXX");
        System.out.println(userWithoutLombok);

        System.out.println("\n--------------------------\n");

        System.out.println("With LOMBOK");
        User user = User.builder().active(false).email("@mail.xui").id(223).build();
        System.out.println(user);
    }
}
