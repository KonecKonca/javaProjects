import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "xXx", "xxx", "1xXxX1", "121enb"));
        list.add("111");
        System.out.println(list);


        // стрим из коллекции
        System.out.println(
                list.stream()
                .filter(s -> s.endsWith("x"))
                .findFirst());  // терминальная операция(после неё уже больше нет потока, а возвкра щ объект)

        System.out.println("\n");

        list.stream()
                .filter(s -> s.startsWith("1"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);   // опять терминальная , после неё нельзя больше лепить ф-ий
        System.out.println("\n");

        // стрим из значений
        String[] mass = {"1", "2"};
        Stream<String> stringStream = Stream.of("a1", "a11", "s", "4a344");  // cюда можно кинуть массив
        stringStream
                .sorted()
                .forEach(System.out::println);
        System.out.println("\n");

        // Стрим из файла
//        Stream<String> stream = Files.lines(Paths.get("test.txt"));
//        stream
//                .sorted()
//                .forEach(System.out::println);

        // ЕЩЁ ВАРИКИ
        Stream.builder().add("a1").add("a0").build();
        Stream<Integer> stream = Stream.iterate(1, e -> e + 3).limit(5);  // последовательность
        stream.forEach(System.out::println);
        Stream<String> stream1 = Stream.generate(() -> "xxx").limit(45);   // одни и те же ( xxx )


    }
}
