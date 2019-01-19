package entity.xml;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class SimpleUtilClass implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("util1");
        return null;
    }

}
