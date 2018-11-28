package com.kozitski.pufar.connection;

public enum ConnectionAttribute {

    // their order must match with connected property
    CONNECTION_URL,
    USER_LOGIN,
    USER_PASSWORD;

    private String value = "";

    ConnectionAttribute() { }
    ConnectionAttribute(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
