import com.sun.deploy.util.SyncAccess;

import java.util.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;


/**
 * @@author Андрей
 * @version 1.1
 * @since 1.0
 * This is my main class, here I will be write my <strong>code</strong>
 * <img src="doc-files/1.JPEG" alt="1"/>  // с .png должно сработать
 */
public class start {

    /**
     * There will be my values
     */
    int nomber;

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
    }

    /**
     *
     * @param i some i
     * @param s some s
     * @throws RuntimeException какое-то описание
     * @return i чтот-то там
     */
    int getMyField(int i, String s) throws RuntimeException{
        return i;
    }

    /**
     * @deprecated занменён на новый метод
     */
    void oldMethod(){}

    /**
     * Ссфлка на док другого класса, метода
     * @see OtherClass#otherMethod()
     * @see "chapter 1"
     */

    /**
     * ССылка через link {@link OtherClass#otherMethod()}  в отличии от see не будет в отдельной обоасти
     */
}
