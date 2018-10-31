import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/hello")
public class Servlet extends HttpServlet{  // implements SingleThreadModel  -- плохо так для каждого потока свои данные
                                                        // + для static не канает
    static int j = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        synchronized (this){
            for(int i = 0; i < 1_000_000; i++){
                j++;
            }
            System.out.println(j);
            System.out.println(Thread.currentThread().getName());
        }
    }
}