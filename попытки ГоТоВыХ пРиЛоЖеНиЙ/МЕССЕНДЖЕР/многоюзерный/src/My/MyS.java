package My;

import server.ClientHandler;
import server.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyS {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(6666);
//        Socket socket = serverSocket.accept();

        while (true){
            Socket clientSocket = serverSocket.accept();
            UserTread client = new UserTread(clientSocket);
            client.start();
        }
    }
}

class UserTread extends Thread{
    private Socket socket = null;
    private PrintWriter out;
    private Scanner in;

    public UserTread(Socket socket){
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            out.println("Server write: I am working now!!!");
            out.flush();
            if(in.hasNext()){
                System.out.println(in.nextLine());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}