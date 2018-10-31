import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@WebServlet("/hello")
public class Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getHeader("Accept-Encoding").contains("gzip")){
            PrintWriter printWriter =  new PrintWriter(new GZIPOutputStream(resp.getOutputStream()));
            printWriter.write("hello from Idea!!!");
        }
    }
}

