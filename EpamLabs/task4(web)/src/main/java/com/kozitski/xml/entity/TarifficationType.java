package com.kozitski.xml.entity;

public enum TarifficationType {
    PER_12_SECOND, PER_30_SECOND, PER_MINUTE;

    public static TarifficationType getType(String value) {
        return valueOf(value);
    }

}
