package com.kozitski.task2.composite.impl.symbol;

import com.kozitski.task2.composite.AbstractText;

import java.util.Objects;

public class TextSign implements AbstractText {
    private String sign;
    public TextSign(String sign) {
        this.sign = sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String getTextMessage() {
        return sign;
    }
    @Override
    public boolean add(AbstractText abstractText) {
        return false;
    }
    @Override
    public boolean remove(AbstractText abstractText) {
        return false;
    }
    @Override
    public boolean removeAll() {
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextSign)) return false;
        TextSign textSign = (TextSign) o;
        return Objects.equals(sign, textSign.sign);
    }
    @Override
    public int hashCode() {
        return 31 * sign.hashCode();
    }
    @Override
    public String toString() {
        return sign;
    }

}
