import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) throws Exception {

        // до точки будет лист строк, по которому и будет происходить итерация
        one().forEach(x -> System.out.println(x));
}

    private static List<String> one(){
        return two();
    }

    private static List<String> two(){
        return StackWalker.getInstance().walk(s -> s.map(frame -> frame.getClassName() + "/" + frame.getMethodName()).collect(Collectors.toList()));
    }
}
