import com.kozitski.task2.composite.impl.TextAll;
import com.kozitski.task2.interpreter.PolishNotationParser;
import com.kozitski.task2.service.TextOperations;
import com.kozitski.task2.util.parser.impl.TextAllParser;
import com.kozitski.task2.util.polishnotation.PolishNotationConverter;
import com.kozitski.task2.util.reader.TextReader;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void test(){

        TextAllParser parser = new TextAllParser();
        String text = TextReader.readAllText(TextReader.INPUT_DATA_PATH);

        TextAll textAll = parser.parse(text);

//        System.out.println(textAll.getParagraph(0).getSentence(1));
//        System.out.println(TextOperations.sortSentencesByTokenLength(textAll));

        System.out.println(TextOperations.reverseSortTokensByNumberOfSymbol(textAll, "a").getParagraph(0).getSentence(0));

    }

    @Test
    public void t(){
//        PolishNotationConverter polishNotationParser = new PolishNotationConverter();
//        polishNotationParser.calculatePolishNotation("(7^5|1&2<<(2|5>>2&71))|1200");

    }

}
