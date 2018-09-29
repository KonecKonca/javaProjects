package andrei.ert.InterShop.config.system;

import andrei.ert.InterShop.config.SpringConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class, WebConfig.class);
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}


//    Вы создали директорию webapp и WEB-INF? Настроили Deployment в Tomcat как в туториале? Через Maven создали архив .war?
// Проверьте еще File -> Projects Structure -> Facets  -> Web.
// В Deployment Descriptors пропишите путь к файлу web.xml, а в Web Resource Directories пропишите путь к папке webapp.﻿