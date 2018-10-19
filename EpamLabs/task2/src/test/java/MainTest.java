import com.kozitski.task2.composite.impl.TextAll;
import com.kozitski.task2.interpreter.Client;
import com.kozitski.task2.interpreter.MathExpression;
import com.kozitski.task2.interpreter.PolishNotationParser;
import com.kozitski.task2.service.ExpressionConverter;
import com.kozitski.task2.service.TextOperation;
import com.kozitski.task2.util.parser.impl.TextAllParser;
import com.kozitski.task2.util.polishnotation.PolishNotationConverter;
import com.kozitski.task2.util.reader.TextReader;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.List;

public class MainTest {

    @Test
    public void test(){

        TextAllParser parser = new TextAllParser();
        String text = TextReader.readAllText(TextReader.INPUT_DATA_PATH);

//        TextAll textAll = parser.parse(text);
//
////        System.out.println(textAll.getParagraph(0).getSentence(1));
////        System.out.println(TextOperation.sortSentencesByTokenLength(textAll));
//
//        System.out.println("\n" + TextOperation.sortSentencesByTokenLength(textAll));


        System.out.println("\n\n");
        ExpressionConverter.convertToInteger(text);

    }

    @Test
    public void t(){
        String EXPRESSION = "(7^5|1&2<<(2|5>>2&71))|1200";  // (3|(2&1>>2|2))  // неправлиьно (мб знак перед скеобкой)  ((2&1>>2|2)|3)

        PolishNotationConverter polishNotationParser = new PolishNotationConverter();
        System.out.println(polishNotationParser.calculatePolishNotation(EXPRESSION));
        PolishNotationParser interpreter = new PolishNotationParser();
        List<MathExpression> list = interpreter.parse(polishNotationParser.calculatePolishNotation(EXPRESSION));

        Client client = new Client();
        int result = client.handleExpression(list);

        System.out.println("\n\n" + result + "\t\t" + ((7^5|1&2<<(2|5>>2&71))|1200));

    }

    public void tt(){

    }

}
