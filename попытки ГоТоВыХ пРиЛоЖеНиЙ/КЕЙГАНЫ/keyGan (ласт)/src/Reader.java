import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(4444);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream)
            ){

            while(true){
                if(scanner.hasNext()){
                    System.out.println(scanner.nextLine());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
