package com.kozitski.xml.builder;

public class XmlParserBuilderFactory {

    public XmlBuilder createBuilder(ParserBuilderType builderType){

        switch (builderType){
            case DOM_PARSER_BUILDER:
                return new DomXmlBuilder();
            case SAX_PARSER_BUILDER:
                return new SaxXmlBuilder();
            case STAX_PARSER_BUILDER:
                return new StaxXmlBuilder();
            default:
                return new DomXmlBuilder();
        }

    }

}
