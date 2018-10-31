import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class start {
    public static void main(String[] args) throws Exception{
        try {
            Error ex = new Error("A");
            ex.addSuppressed(new Error("B"));
            ex.addSuppressed(new Error("C"));
            throw ex;
        }
        catch(Error e){
            throw e;
        }
    }
}
