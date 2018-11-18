package com.kozitski.xml.entity;

public enum OperatorName {
    Velcome, Life, MTS;

    public static OperatorName getType(String value) {
        return valueOf(value);
    }

}
