import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//    localhost  --- 127.0.0.1  --- InetAddress.getLocalHost()  (локальный айпишник своего компа)
public class start {
    public static void main(String[] args) throws Exception{
        try(ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream())){
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);  // autoflush чтоб считывались данные
            printWriter.println("Hello");


//            while(scanner.hasNextLine()){
//                String str = scanner.nextLine();
//                printWriter.println("You send: " + str);
//                System.out.println(str);
//                if(str.equals("exit")){
//                    break;
//                }
//            }

        }
    }
}
