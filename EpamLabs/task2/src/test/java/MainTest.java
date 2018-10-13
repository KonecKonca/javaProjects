import com.kozitski.task2.composite.impl.TextAll;
import com.kozitski.task2.util.reader.TextReader;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void test(){

        String str = TextReader.readAllText("src/main/resources/data/input.txt");

        TextAll sentence = new TextAll(str);
//        System.out.println(sentence);


        System.out.println(sentence.getParagraph(0).getSentence(1));



    }

}
