import java.awt.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;

// По факту на позволяет выполнять некоторые действия перед методом каждым
// Техника для реализации интерфейсов(пригодится в АОП)
// Связанно с темой Рефлексия
public class start{
    public static void main(String[] args){

        InvocationHandler handler = new MyProxy(new Integer(5));
        Class[] classes = new Class[]{Comparable.class, Callable.class};  // В фигурный все интерфейсы, которые хотим заимплементить
        Object proxy = Proxy.newProxyInstance(null, classes, handler);

        // Мы не заходим в оригинальный метод, а заходим в invoke
        // уже из invoke мы можем рекурсивно через invoke вызвать оригинальный метод
        proxy.getClass();
        proxy.toString();  // перед этим сначала выведется XXX (тут вход в invoke())
        System.out.println(((Comparable)proxy).compareTo(3));
    }

    static class MyProxy implements InvocationHandler{
        Object target;

        public MyProxy(Object target){
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Parametrs " + args);  //XXX
            return method.invoke(target, args);  // вызов оригинального метода
        }
    }
}

