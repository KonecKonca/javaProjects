package com.kozitski.xml.builder;

import com.kozitski.xml.entity.*;
import com.kozitski.xml.exception.XMLParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static com.kozitski.xml.builder.BuilderUtil.*;

public class DomXmlBuilder implements XmlBuilder {

    @Override
    public List<Tariff> buildTariffs(String xmlPath) throws XMLParseException {

        ArrayList<Tariff> tariffs = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XMLParseException(e);
        }
        Document document;

        try {
            document = builder.parse(new File(xmlPath));
        } catch (SAXException | IOException e) {
            throw new XMLParseException(e);
        }

        NodeList limitTariffList = document.getElementsByTagName(convertToXmlFormat(TariffXsdElement.LIMIT_TARIFF));
        NodeList unlimitTariffList = document.getElementsByTagName(convertToXmlFormat(TariffXsdElement.UNLIMIT_TARIFF));

        for (int index = 0; index < limitTariffList.getLength(); index++) {
            tariffs.add(buildLimitTariff(limitTariffList.item(index)));
        }

        for (int index = 0; index < unlimitTariffList.getLength(); index++) {
            tariffs.add(buildUnlimitTariff(unlimitTariffList.item(index)));
        }

        return tariffs;
    }

    private LimitTariff buildLimitTariff(Node node) {
        LimitTariff limitTariff = new LimitTariff();
        NodeList limitTariffNodes = node.getChildNodes();
        buildTariff(limitTariff, node);

        int PRICE_IN_MINUTE_EXTERNAL_CALLS_NUMBER = 9;
        String priceExtrnal = getElement(limitTariffNodes, PRICE_IN_MINUTE_EXTERNAL_CALLS_NUMBER);
        limitTariff.setExternalCallPrice(Double.parseDouble(priceExtrnal));

        int PRICE_IN_MINUTE_INNER_CALLS_NUMBER = 11;
        String priceInner = getElement(limitTariffNodes, PRICE_IN_MINUTE_INNER_CALLS_NUMBER);
        limitTariff.setInternalCallPrice(Double.parseDouble(priceInner));

        int PRICE_FOR_MB_INTERNET_NUMBER = 13;
        String priceInternet = getElement(limitTariffNodes, PRICE_FOR_MB_INTERNET_NUMBER);
        limitTariff.setMbPrice(Double.parseDouble(priceInternet));

        return limitTariff;
    }
    private UnlimitTariff buildUnlimitTariff(Node node) {
        UnlimitTariff unlimitTariff = new UnlimitTariff();
        NodeList unlimitTariffyNodes = node.getChildNodes();
        buildTariff(unlimitTariff, node);

        String attributeIsExternallCalls = getAttribure(node, TariffXsdElement.IS_EXTERNAL_CALLS);
        unlimitTariff.setHasExternalCall(TRUE_VALUE.equalsIgnoreCase(attributeIsExternallCalls));

        String attributeInnerCalls = getAttribure(node,TariffXsdElement.IS_INNER_CALLS);
        unlimitTariff.setHasInternalCall(TRUE_VALUE.equalsIgnoreCase(attributeInnerCalls));

        String attributeIsInternet = getAttribure(node,TariffXsdElement.IS_INTERNET);
        unlimitTariff.setHasInternet(TRUE_VALUE.equalsIgnoreCase(attributeIsInternet));

        int PAYROLL_NUMBER = 9;
        String payroll = getElement(unlimitTariffyNodes, PAYROLL_NUMBER);
        unlimitTariff.setPayroll(Double.parseDouble(payroll));

        return unlimitTariff;
    }
    private void buildTariff(Tariff tariff, Node node) {
        NodeList tariffNodes = node.getChildNodes();

        int NAME_NUMBER = 1;
        String name = getElement(tariffNodes, NAME_NUMBER);
        tariff.setName(name);

        int OPERATOR_NAME_NUMBER = 3;
        String operatorName = getElement(tariffNodes, OPERATOR_NAME_NUMBER);
        tariff.setOperatorName(OperatorName.getType(operatorName));

        int SMS_PRICE_NUMBER = 5;
        String smsPrice = getElement(tariffNodes, SMS_PRICE_NUMBER);
        tariff.setSmsPrice(Integer.valueOf(smsPrice));


        int PARAMETERS_NUMBER = 7;
        tariff.setTariffParameters(buildParameters(tariffNodes.item(PARAMETERS_NUMBER)));

    }
    private TariffParameters buildParameters(Node parametersNode) {
        TariffParameters parameters = new TariffParameters();
        NodeList parametersNodes = parametersNode.getChildNodes();

        String attributeIsExternallCalls = getAttribure(parametersNode, TariffXsdElement.FAVOURITE_NUMBER);
        parameters.setFavouriteNumber(attributeIsExternallCalls);

        int TARIFICATION_NUMBER = 1;
        String tarification = getElement(parametersNodes, TARIFICATION_NUMBER).toUpperCase();
        parameters.setTarifficationType(TarifficationType.getType(tarification));

        int PAY_FOR_CONNECTION_NUMBER = 3;
        String payForConnection = getElement(parametersNodes, PAY_FOR_CONNECTION_NUMBER);
        parameters.setPayForConnection(Double.parseDouble(payForConnection));

        return parameters;
    }

    private String getElement(NodeList list,int number){
        return list.item(number).getTextContent();
    }
    private String getAttribure(Node node, Enum attribute){
        String xmlAttribute = convertToXmlFormat(attribute);
        return ((Element) node).getAttribute(xmlAttribute);
    }
    private String convertToXmlFormat(Enum element){
        String stringElement = element.toString();
        return stringElement.replace('_','-').toLowerCase();
    }

}
