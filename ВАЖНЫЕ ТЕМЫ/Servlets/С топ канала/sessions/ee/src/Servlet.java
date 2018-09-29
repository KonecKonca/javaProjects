import com.mysql.cj.xdevapi.Session;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

//  сессия хранится на серваке , т.е (после перезапуска сервера сессия не сохранятеся, но если только перазап браузер, то сессия сохрагится)

@WebServlet("/hello")
public class Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("one", "two");
        session.setAttribute("one1", "two1");

        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String attrinuteName = attributeNames.nextElement();
            resp.getWriter().write(attrinuteName + " = " + session.getAttribute(attrinuteName) + "\n");
        }
    }
}

