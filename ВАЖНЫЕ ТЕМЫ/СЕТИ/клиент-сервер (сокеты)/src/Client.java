import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        try(Socket socket = new Socket()){
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8888), 2000);  // timeout на случай проблемы
            Scanner scanner = new Scanner(socket.getInputStream());
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }
    }
}
