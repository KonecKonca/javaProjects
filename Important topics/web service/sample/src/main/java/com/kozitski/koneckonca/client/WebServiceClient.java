package com.kozitski.koneckonca.client;

import com.kozitski.koneckonca.service.WebServiceTest;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class WebServiceClient {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:1986/wss/hello?wsdl");
        QName qname = new QName("http://impl.service.koneckonca.kozitski.com/", "WebServiceImplService");

        Service service = Service.create(url, qname);
        WebServiceTest webService = service.getPort(WebServiceTest.class);

        System.out.println(webService.method("any message"));

    }

}
