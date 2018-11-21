package com.kozitski.xml.builder;

import com.kozitski.xml.entity.*;
import com.kozitski.xml.exception.XMLParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.kozitski.xml.builder.BuilderUtil.*;

public class SaxXmlBuilder extends DefaultHandler implements XmlBuilder {
    private SAXParser saxParser;
    private TariffXsdElement currentTag;
    private ArrayList<Tariff> tariffs = new ArrayList<>();
    private Tariff currentTariff;
    private TariffParameters currentParameters;

    private void createParser() throws XMLParseException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            saxParser = factory.newSAXParser();
        }
        catch (ParserConfigurationException | SAXException e) {
            throw new XMLParseException("SAXParserFactory didn't create newInstance", e);
        }
    }

    @Override
    public List<Tariff> buildTariffs(String xmlPath) throws XMLParseException {
        createParser();

        tariffs = new ArrayList<>();

        try {
            saxParser.parse(xmlPath, this);
        } catch (SAXException | IOException e) {
            throw new XMLParseException("Parse exception", e);
        }

        return tariffs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        String tagName = qName.toUpperCase().replace(WHAT_REPLACE, ON_REPLACE);
        if (TariffXsdElement.containsElement(tagName)) {
            currentTag = TariffXsdElement.valueOf(tagName);
            switch (currentTag) {
                case LIMIT_TARIFF: {
                    currentTariff = new LimitTariff();
                    tariffs.add(currentTariff);
                    break;
                }
                case UNLIMIT_TARIFF: {
                    currentTariff = new UnlimitTariff();

                    boolean isInnerCalls = TRUE_VALUE.equalsIgnoreCase(attributes.getValue(0));
                    ((UnlimitTariff) currentTariff).setHasInternalCall(isInnerCalls);


                    boolean isExternalCalls = TRUE_VALUE.equalsIgnoreCase(attributes.getValue(1));
                    ((UnlimitTariff) currentTariff).setHasExternalCall(isExternalCalls);


                    boolean isInternet = TRUE_VALUE.equalsIgnoreCase(attributes.getValue(2));
                    ((UnlimitTariff) currentTariff).setHasInternet(isInternet);

                    tariffs.add(currentTariff);
                    break;
                }

                case PARAMETERS: {
                    currentParameters = new TariffParameters();
                    currentTariff.setTariffParameters(currentParameters);

                    String number = attributes.getValue(0);
                    currentParameters.setFavouriteNumber(number);

                }

            }
        }

    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (currentTag != null) {
            switch (currentTag) {
                case NAME: {
                    String name = new String(chars, start, length);
                    currentTariff.setName(name);
                    break;
                }
                case OPERATOR_NAME: {
                    String operatorName = new String(chars, start, length);
                    currentTariff.setOperatorName(OperatorName.getType(operatorName));
                    break;
                }
                case SMS_PRICE: {
                    double smsPrice = Double.valueOf(new String(chars, start, length));
                    currentTariff.setSmsPrice(smsPrice);
                    break;
                }
                case FAVOURITE_NUMBER: {
                    String  isFavouriteNumber = new String(chars, start, length);
                    currentParameters.setFavouriteNumber(isFavouriteNumber);
                    break;
                }
                case TARIFFICATION: {
                    TarifficationType tarification = TarifficationType.getType(new String(chars, start, length).toUpperCase());
                    currentParameters.setTarifficationType(tarification);
                    break;
                }
                case PAY_FOR_CONNECTION: {
                    double payForConnection = Double.valueOf(new String(chars, start, length));
                    currentParameters.setPayForConnection(payForConnection);
                    break;
                }
                case PRICE_IN_MINUTE_EXTERNAL_CALLS: {
                    double priceInMinuteExternalTariff =  Double.valueOf(new String(chars, start, length));
                    ((LimitTariff) currentTariff).setExternalCallPrice(priceInMinuteExternalTariff);
                    break;
                }
                case PRICE_IN_MINUTE_INNER_CALLS: {
                    double priceInMinuteInnerTariff = Double.valueOf(new String(chars, start, length));
                    ((LimitTariff) currentTariff).setInternalCallPrice(priceInMinuteInnerTariff);
                    break;
                }
                case PRICE_FOR_MB_INTERNET: {
                    double priceForMbInternet =  Double.valueOf(new String(chars, start, length));
                    ((LimitTariff) currentTariff).setMbPrice(priceForMbInternet);
                    break;
                }
                case PAYROLL: {
                    double payroll = Double.valueOf(new String(chars, start, length));
                    ((UnlimitTariff) currentTariff).setPayroll(payroll);
                    break;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        currentTag = null;
    }

}