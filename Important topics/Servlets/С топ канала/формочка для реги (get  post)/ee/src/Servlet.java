import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;

@WebServlet("/hello")
public class Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("one");
        String pass = req.getParameter("two");

        String str =
                "<html>" +
                    "<head></head>" +
                        "<body>" +
                            "<form action='hello' method='post'>" +    // тут меняем гет на пост
                                "<input type ='text' name='one'/>" +
                                "<input type ='text' name='two'/>" +
                                "<input type ='submit' name='submit'/>" +
                        "</form>" +
                        "one = " + login + "\t" +
                        "two = " + pass +
                        "</body>" +
                "</html>";
        resp.getWriter().write(str);

        System.out.println("login\t" + login);
        System.out.println("pass\t" + pass);


    }

    // в отличии от гета не светит параметры в строчке где URL
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}