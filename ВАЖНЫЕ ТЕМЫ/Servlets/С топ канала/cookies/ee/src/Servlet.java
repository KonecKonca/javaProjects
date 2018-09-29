import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

//  к сожалению видны только куки для данной странички

@WebServlet("/hello")
public class Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for(Cookie c : cookies){
            System.out.println(c.getName() + "\t" + c.getValue());
            resp.getWriter().write(c.getName() + "\t" + c.getValue() + "\n");
        }

        Cookie cookie = new Cookie("testCoocie", "abcTest");
        cookie.setMaxAge(5);  // 5 сек будет существовать , -1 --- вечно
        cookie.setPath("/hello");  // куки доступен онли для этой странички
        cookie.setDomain("my.localhost.com");   // чтоб куки было видно не только на локалхосте (для этого обязательно должщен куки оставаться га локал хосте), а и ещё где-то
        resp.addCookie(cookie);


    }
}

