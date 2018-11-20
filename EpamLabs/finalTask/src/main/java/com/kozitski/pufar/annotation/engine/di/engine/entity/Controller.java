package com.kozitski.pufar.annotation.engine.di.engine.entity;


import com.kozitski.pufar.annotation.engine.di.engine.Inject;

public class Controller {

    @Inject(name = "dao")
    private DaoImpl daoImpl;

    @Inject(name = "service")
    private ServiceImpl serviceImpl;

    public void setDaoImpl(DaoImpl daoImpl) {
        this.daoImpl = daoImpl;
    }
    public void setServiceImpl(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @Override
    public String toString() {
        return  "serviceImpl=" + serviceImpl +
                ", daoImpl=" + daoImpl;
    }

}
