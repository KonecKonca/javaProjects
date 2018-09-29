import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.omg.CORBA.portable.ValueInputStream;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        FilterManager filterManager = new FilterManager();

        filterManager.setFilter(new AuthFilter());
        filterManager.setFilter(new IPFilter());

        filterManager.filterRequest(" INPUT DATA!!!! ");
    }
}

// иерархия каких-то прокерок ФИЛЬТРОВ
interface Filter{
    void execute(String data);
}
class AuthFilter implements Filter{
    @Override
    public void execute(String data) {
        System.out.println("Auth filter");
    }
}
class IPFilter implements Filter{
    @Override
    public void execute(String data) {
        System.out.println("IP filter");
    }
}

// То что должно выполниться после проверок
class Target{
    void doJob(String data){
        System.out.println("data came in: " + data);
    }
}

class FilterChain{
    private List<Filter> filterList  = new ArrayList<>();
    private Target target = new Target();
    void addFilter(Filter filter){
        filterList.add(filter);
    }

    public void filter(String request){
        for(Filter filter : filterList){
            filter.execute(request);
        }
        target.doJob(request);
    }
}

class FilterManager{
    private FilterChain filterChain = new FilterChain();

    void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }
    void filterRequest(String request){
        filterChain.filter(request);
    }
}