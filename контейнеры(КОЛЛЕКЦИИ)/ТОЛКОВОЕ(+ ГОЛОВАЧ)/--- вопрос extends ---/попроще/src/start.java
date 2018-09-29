import com.sun.deploy.util.SyncAccess;

import java.io.*;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.newObjectType;


public class start {
    public static void main(String[] args) throws Exception {

        List<B> b1 = new ArrayList<>();
        List<B> b2 = b1;

        // List<A> a1 = b1;  так нельзя

        List<? extends B> a2 = b1;
        List<? extends A> a3 = b1;
    }
}

class A{

}

class B extends A{

}
