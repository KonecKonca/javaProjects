import jdk.nashorn.internal.objects.annotations.Function;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("d:\\джава проекты");
        long count = Files.walk(dir)
                .filter((p) -> p.toString().endsWith(".tex"))
                .peek(System.out::println)
                .flatMap(MainClass::getLines)
                .filter((s) -> s.contains("Java"))
                .peek(System.out::println)
                .count();

        System.out.println(count);
    }

    private static Stream<String> getLines(Path file){
        try {
            return Files.lines(file);
        }
        catch (IOException e){
            throw  new UncheckedIOException(e);
        }
    }
}
