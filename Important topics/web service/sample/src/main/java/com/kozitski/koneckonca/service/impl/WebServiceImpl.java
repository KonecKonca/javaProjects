package com.kozitski.koneckonca.service.impl;

import com.kozitski.koneckonca.service.WebServiceTest;

import javax.jws.WebService;

@WebService(endpointInterface = "com.kozitski.koneckonca.service.WebServiceTest")
public class WebServiceImpl implements WebServiceTest {

    @Override
    public String method(String data) {
        return "U send me: " + data;
    }

}
