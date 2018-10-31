import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.omg.CORBA.portable.ValueInputStream;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.doTask("eJb");
        businessDelegate.doTask("jmS");
    }
}

interface BusinessService{
    void doJob();
}
class EJBService implements BusinessService{
    @Override
    public void doJob() {
        System.out.println("Do EJB .... ");
    }
}
class JMSSerive implements BusinessService{
    @Override
    public void doJob() {
        System.out.println("Do JMS .... ");
    }
}

class LookUPService{
    public BusinessService getService(String servieType){
        if(servieType.equalsIgnoreCase("ejb")){
            return new EJBService();
        }
        else {
            return new JMSSerive();        }
    }
}
class BusinessDelegate{
    private LookUPService lookUPService = new LookUPService();
    private BusinessService businessService;

    void doTask(String serviceType){
        businessService = lookUPService.getService(serviceType);
        businessService.doJob();
    }
}
