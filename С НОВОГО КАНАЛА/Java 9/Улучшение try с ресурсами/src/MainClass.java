import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) throws Exception {

        // до джавы 9
        try(OutputStream outputStream = new FileOutputStream("xxx.txt")){
            outputStream.write('f');
        }

        // в 9-ке
        OutputStream outputStream1 = new FileOutputStream("xxx.txt");
        try(outputStream1){
            outputStream1.write('f');
        }
    }
}
