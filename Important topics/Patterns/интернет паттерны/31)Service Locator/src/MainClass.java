import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.omg.CORBA.portable.ValueInputStream;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        Service service = ServiceLocator.getService("service1");
        service.execute();

        service = ServiceLocator.getService("service2");
        service.execute();
    }
}

interface Service{
   String getName();
   void execute();
}
class Service1 implements Service{
    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("Executing service1");
    }
}
class Service2 implements Service{
    @Override
    public String getName() {
        return "Service2";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service2");
    }
}

class InitialContext{
    public Object lookup(String name){
        if(name.equalsIgnoreCase("service1")){
            return new Service1();
        }
        if(name.equalsIgnoreCase("service2")){
            return new Service2();
        }
        return null;
    }
}


class Cache{
    private List<Service> services = new ArrayList<>();
    public Service getService(String serviceName){
        for(Service service : services){
            if(service.getName().equalsIgnoreCase(serviceName)){
                System.out.println("Returning cashing " + serviceName + " object");
                return service;
            }
        }
        return null;
    }

    public void addService(Service newService){
        boolean exists = false;
        for(Service service : services){
            if(service.getName().equalsIgnoreCase(newService.getName())){
                exists = true;
            }
        }
        if(!exists){
            services.add(newService);
        }
    }
}

class ServiceLocator{
    private static Cache cache = new Cache();
    public static Service getService(String name){
        Service service = cache.getService(name);
        if(service != null){
            return service;
        }
        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(name);
        cache.addService(service1);
        return service1;
    }
}



















