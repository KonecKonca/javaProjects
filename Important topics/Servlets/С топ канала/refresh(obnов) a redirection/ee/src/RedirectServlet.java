import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/xxx")
public class RedirectServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Was Redirection " + Math.random()*100);

        resp.setHeader("Refresh", "1");  // обновлять страничку каждые 2 секунды

        if((int)(Math.random()*10) == 5){
            resp.setHeader("Refresh", "2;URL=https://google.com");   // перенаправления на др страничку гугла через 2 секунды
        }
    }
}
