package com.kozitski.pufar.annotation.engine.di.engine;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.lang.reflect.Field;

public class InjectionServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        // amy configs for

        try {

            ApplicationContext context = (ApplicationContext) Class.forName("com.kozitski.pufar.annotation.engine.di.engine.RealApplicationContext").newInstance();
            context.init("xmlPath");

            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields){


            }

        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
