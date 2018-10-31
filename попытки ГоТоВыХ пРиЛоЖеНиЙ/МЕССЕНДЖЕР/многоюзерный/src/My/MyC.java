package My;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyC {
    public static void main(String[] args) throws IOException, InterruptedException {
        new Thread(() -> start()).start();
        new Thread(() -> start()).start();
    }

    static void start()  {
        try {
            Socket socket = new Socket("192.168.100.2", 6666);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream());

            System.out.println("Введите имя: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            int counter = 0;
            while (true){
                Thread.sleep(1500);
                String text = "" + counter;
                out.println(name + ": " + text);
                out.flush();
                if(in.hasNext()){
                    System.out.println("Server write: " + in.nextLine());
                }
                out.flush();
                counter++;
            }
        }
        catch (Exception e){
            System.out.println("ЧТо-то пошло не так!!))");
        }
    }
}
