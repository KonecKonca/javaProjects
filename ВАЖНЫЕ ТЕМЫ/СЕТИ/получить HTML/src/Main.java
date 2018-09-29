import com.sun.jndi.toolkit.url.Uri;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        URLConnection connection = new URL("https://www.google.ru").openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        //scanner.useDelimiter("\\Z");  // хз зачем
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        System.out.println("\n\n");

        // Вывод хедеров
        Map<String, List<String>> headerFiles = connection.getHeaderFields();
        for(Map.Entry<String, List<String>> entry : headerFiles.entrySet()){
            System.out.println(entry.getKey() + " / " + entry.getValue());
        }
    }
}