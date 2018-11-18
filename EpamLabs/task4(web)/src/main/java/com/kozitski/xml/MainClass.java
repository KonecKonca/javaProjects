package com.kozitski.xml;


import com.kozitski.xml.entity.Tariff;
import com.kozitski.xml.exception.XMLParseException;
import com.kozitski.xml.builder.DomXmlBuilder;
import com.kozitski.xml.builder.SaxXmlBuilder;
import com.kozitski.xml.builder.StaxXmlBuilder;
import com.kozitski.xml.builder.XmlBuilder;
import com.kozitski.xml.validator.SchemeValidator;

import java.util.List;
import java.util.Objects;

public class MainClass {

    public static void main(String[] args) {

//        validate();
//
//        sax();
//        dom();

        stax();

    }

    private static void dom() {
        XmlBuilder domXmlBuilder = new DomXmlBuilder();
        try {
            List<Tariff> list = domXmlBuilder.buildTariffs(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(SchemeValidator.XML_PATH)).getFile());

            for (Tariff tariff : list) {
                System.out.println(tariff);
                System.out.println("------------------------------------------------------------");
            }
        }
        catch (XMLParseException e) {
            e.printStackTrace();
        }

    }
    private static void sax(){
        XmlBuilder parser = new SaxXmlBuilder();
        try {
            List<Tariff> list = parser.buildTariffs(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(SchemeValidator.XML_PATH)).getFile());

            for (Tariff tariff : list) {
                System.out.println(tariff);
                System.out.println("-----------------------------------------------------------");
            }

        }
        catch (XMLParseException e) {
            e.printStackTrace();
        }
    }
    private static void stax(){
        XmlBuilder staxXmlBuilder = new StaxXmlBuilder();
        try {
            List<Tariff> list = staxXmlBuilder.buildTariffs(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(SchemeValidator.XML_PATH)).getFile());

            for (Tariff tariff : list) {
                System.out.println(tariff);
                System.out.println("-------------------------------------------------------------");
            }
        }
        catch (XMLParseException e) {
            e.printStackTrace();
        }
    }


    private static void validate(){
        SchemeValidator.validate(SchemeValidator.XML_PATH, SchemeValidator.XSD_PATH);
    }

}
