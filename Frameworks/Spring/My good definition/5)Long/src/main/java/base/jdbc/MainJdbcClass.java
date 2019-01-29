package base.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Optional;

public class MainJdbcClass {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        UserDao userDao = context.getBean("MySQLDao", UserDao.class);

        List<User> users = userDao.searchUsersByIdRangeWithLimit(3, 4, 10);
        users.forEach(System.out::println);

        System.out.println("\n----------------------------------\n");

        User user = User.builder().login("222").password("1111").status(1).banStatus(false)
                .number(Number.builder().country("+375").operator("29").number("2151385").build()).build();

        System.out.println(userDao.insertUsers(user));

    }

}
