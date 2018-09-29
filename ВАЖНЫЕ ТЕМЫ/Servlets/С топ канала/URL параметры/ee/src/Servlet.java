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
        resp.getWriter().write("Hello from idea!!!!");

        String one = req.getParameter("one");  // Strng names[] = getParametrValues("name") -- в случае совпадения ключа
        String two = req.getParameter("two");
        System.out.println(one + "\t" + two);

        Enumeration<String> parametrNames = req.getParameterNames();
        while(parametrNames.hasMoreElements()){
            String currentValue = parametrNames.nextElement();
            System.out.println(currentValue + "\t" + req.getParameter(currentValue));
        }

        System.out.println(req.getQueryString());   // сама строка запроса, можно вручную парсить
                                                        // все параметры(т.е все после ?)
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
}