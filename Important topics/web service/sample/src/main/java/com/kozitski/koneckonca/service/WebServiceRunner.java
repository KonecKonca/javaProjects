package com.kozitski.koneckonca.service;


import com.kozitski.koneckonca.service.impl.WebServiceImpl;

import javax.xml.ws.Endpoint;

public class WebServiceRunner {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:1986/wss/hello", new WebServiceImpl());
    }

}


// итсточник
// https://javarush.ru/groups/posts/1168-veb-servisih-shag-1-chto-takoe-veb-servis-i-kak-s-nim-rabotatjh

