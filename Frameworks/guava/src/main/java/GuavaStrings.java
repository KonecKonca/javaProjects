import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

public class GuavaStrings {

    @Test
    public void stringsSuffix(){
        System.out.println(Strings.commonSuffix("Mike", "Coke"));
        System.out.println(Strings.commonSuffix("Mike", "CoKe"));
    }

    @Test
    public void padding(){

        System.out.println(Strings.padEnd("any strings", 20, '_'));

        System.out.println(Strings.repeat("1", 20));

        ImmutableList.of("Andrei", "Vasia", "Petter")
                .stream()
                .map(s -> Strings.padStart(s,10, '_'))
                .map(s -> Strings.padEnd(s,20, '_'))
                .forEach(System.out::println);

    }


    @Test
    public void joinerAndSplitter(){

        String str = "1 text, 2 text, 3 text";

        Iterable<String> iterable = Splitter.on("text").split(str);
        for (String string: iterable) {
            System.out.println(string);
        }

        String result = Joiner.on("book").join(iterable);
        System.out.println(result);

    }

}
