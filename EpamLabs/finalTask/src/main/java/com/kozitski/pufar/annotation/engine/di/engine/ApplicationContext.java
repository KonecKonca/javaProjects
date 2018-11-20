package com.kozitski.pufar.annotation.engine.di.engine;


public interface ApplicationContext {

    void init(String xmlPath);
    Object getBean(String name);
    <T> T getBean(String name, Class<T> calzz);

}
