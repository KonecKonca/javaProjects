package com.kozitski.task2.composite.impl;

import com.kozitski.task2.composite.AbstractText;
import com.kozitski.task2.composite.impl.symbol.TextLetter;
import com.kozitski.task2.composite.impl.symbol.TextSign;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextComponent implements AbstractText {
    private List<AbstractText> components = new ArrayList<>();
    private TypeOfTextComponent type;

    public void add(int index, AbstractText element) {
        components.add(index, element);
    }
    public TextComponent(TypeOfTextComponent type) {
        this.type = type;
    }

    @Override
    public int countOfOrderedSymbol(String symbol) {
        int counter = 0;
        for(AbstractText abstractText : components){
            counter += abstractText.countOfOrderedSymbol(symbol);
        }

        return counter;
    }
    @Override
    public TypeOfTextComponent getTypeOfTextComponent() {
        return type;
    }
    @Override
    public AbstractText getComponent(int index) {
        return components.get(index);
    }
    @Override
    public int getComponentsSize() {
        return components.size();
    }
    @Override
    public String getTextMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        components.removeIf(Objects::isNull);
        switch (type){
            case TEXT:
                components.forEach(o -> stringBuilder.append("\n\t").append(o.getTextMessage()));
                break;
            case PARAGRAPH:
                components.forEach(o -> stringBuilder.append(o.getTextMessage()));
                break;
            case SENTENCE:
                components.forEach(o -> stringBuilder.append(o.getTextMessage()).append(" "));
                break;
            case LEXEME:
                components.forEach(o -> stringBuilder.append(o.getTextMessage()));
                break;
            case WORD:
                components.forEach(o -> stringBuilder.append(o.getTextMessage()));
                break;
            default:
                components.forEach(o -> stringBuilder.append(o.getTextMessage()));
        }

        return stringBuilder.toString();
    }
    @Override
    public boolean add(AbstractText abstractText) {
        return components.add(abstractText);
    }
    @Override
    public boolean remove(AbstractText abstractText) {
        return components.remove(abstractText);
    }
    @Override
    public boolean removeAll() {
        components = new ArrayList<>();
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextComponent)) return false;
        TextComponent that = (TextComponent) o;
        return Objects.equals(components, that.components) &&
                type == that.type;
    }
    @Override
    public int hashCode() {
        int hashCode = type.hashCode();
        for(AbstractText abstractText : components){
            hashCode += abstractText.hashCode() * 31;
        }

        return hashCode;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(AbstractText paragraph : components){
            stringBuilder.append("\n\t");
            stringBuilder.append(paragraph.getTextMessage());
        }
        return stringBuilder.toString();
    }

}
