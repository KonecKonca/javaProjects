import com.sun.deploy.util.SyncAccess;

import java.io.*;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.newObjectType;


public class start {
    public static void main(String[] args) throws Exception {

    }
}

interface A{
    default void x(){
        System.out.println("xxxxxxxxx");
    }
}

interface B{
    default void x(){
        System.out.println("yyyyyyyyyyy");
    }
}

class use implements A, B{   /// не проканает(т.к будет непонятно какой метод юзать)

}