import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>( Arrays.asList("1", "4", "2", "3f", "123", "ferfer", "xXx", "fff"));

        list.stream()   // ничего не выведется из-за ленивости (нужен в конце треминальный метод)
                .filter(e -> {
                    System.out.println(e);
                    return true;
                });

        list.stream()
                .filter(e -> {
                    System.out.println("Фильтр " + e);
                    return true;
                })
                .forEach(System.out::println);  // есть в конце терминальный метод
        System.out.println("\n\n");

        list.stream()
                .map(s -> {
                    System.out.println("map " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anymatch " + s);
                    return s.startsWith("2");
                });
        System.out.println("\n\n");


    }
}
