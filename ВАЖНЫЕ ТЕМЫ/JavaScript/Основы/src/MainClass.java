import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ForkJoinPool;

public class MainClass{
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        engine.put("k", 4);
        String code = "print('Hello');"
                + "function f(a){return a + 6;};"
                + "var n = 1 + 2;"
                + "n + 3 + k";

        Object o = engine.eval(code);
        System.out.println(o);

        Object o2 = ((Invocable)engine).invokeFunction("f",1);
        System.out.println(o2);

        Object o3 = ((Invocable)engine).invokeFunction("f","1");
        System.out.println(o3);

        System.out.println(engine.get("n"));
    }
}


