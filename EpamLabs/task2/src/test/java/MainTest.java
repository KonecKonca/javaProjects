import com.kozitski.task2.composite.impl.redundant.TextAll;
import com.kozitski.task2.service.ExpressionConverter;
import com.kozitski.task2.util.parser.impl.TextAllParser;
import com.kozitski.task2.util.reader.TextReader;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void test(){

        TextAllParser parser = new TextAllParser();
        String text = TextReader.readAllText(TextReader.INPUT_DATA_PATH);
        ExpressionConverter converter = new ExpressionConverter();
        String changeText = converter.replaceNumberExpressionsByNumber(text);
        TextAll textAll = parser.parse(changeText);





//        System.out.println(TextOperation.sortSentencesByTokenLength(textAll));
//        System.out.println("\n" + TextOperation.sortSentencesByTokenLength(textAll));


    }

    @Test
    public void tt(){

    }


}
