import com.sun.deploy.util.SyncAccess;

import java.util.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class start {
    public static void main(String[] args) throws Exception{
        Book x = new Book("one");
        Book y = new Book("one");
        Book z = new Book("one");

        // reflixive
        System.out.println("reflixive");
        System.out.println(x.equals(x));  // must be tue
        System.out.println();

        // simmetric
        System.out.println("simmetric");
        System.out.println(x.equals(y));  //должны быть одинаковые значения
        System.out.println(y.equals(x));
        System.out.println();


        // transitive
        System.out.println("transitive");
        System.out.println(x.equals(y));  // так же одинаковые значения
        System.out.println(x.equals(z));
        System.out.println(x.equals(z));
        System.out.println();


        // consistent
        System.out.println("consistent");
        System.out.println(x.equals(y));  // при любом запуске в независимости от времени
        System.out.println(x.equals(y));  // должны быть одинак значения
        System.out.println(x.equals(y));
        System.out.println();

        // not null
        System.out.println("not null");  // всегда false
        System.out.println(x.equals(null));
        System.out.println();
    }
}

class Book{
    String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book) {
            return obj != null && this.title.equals(((Book) obj).title);
        }
        return false;
    }
}
