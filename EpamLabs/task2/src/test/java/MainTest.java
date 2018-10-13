import com.kozitski.task2.composite.impl.TextAll;
import com.kozitski.task2.service.TextOperations;
import com.kozitski.task2.util.parser.impl.TextAllParser;
import com.kozitski.task2.util.reader.TextReader;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void test(){

        TextAllParser parser = new TextAllParser();
        String text = TextReader.readAllText(TextReader.INPUT_DATA_PATH);

        TextAll textAll = parser.parse(text);

//        System.out.println(textAll.getParagraph(0).getSentence(1));

        System.out.println(TextOperations.sortParagraphsByNumOFSentences(textAll));


    }

}
