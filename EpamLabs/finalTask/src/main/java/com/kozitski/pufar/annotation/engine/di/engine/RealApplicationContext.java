package com.kozitski.pufar.annotation.engine.di.engine;

public class RealApplicationContext implements ApplicationContext{
    private String xmlPath;

    @Override
    public void init(String xmlPath) {

    }

    @Override
    public Object getBean(String name) {
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<T> calzz) {
        return null;
    }

}
