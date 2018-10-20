package com.kozitski.task2.composite.impl;

import com.kozitski.task2.composite.AbstractText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextComponent implements AbstractText {
    private static final Logger LOGGER = LogManager.getLogger(AbstractText.class);
    private List<AbstractText> components = new ArrayList<>();
    private TypeOfTextComponent type;


    public TypeOfTextComponent getType() {
        return type;
    }
    public TextComponent(TypeOfTextComponent type) {
        this.type = type;
    }

    @Override
    public String getTextMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        components.removeIf(Objects::isNull);
        switch (type){
            case TEXT:
                components.forEach(o -> stringBuilder.append(o.getTextMessage()).append("\n\t"));
                break;
            case PARAGRAPH:
                components.forEach(o -> stringBuilder.append(o.getTextMessage()).append(" "));
                break;
            case SENTENCE:
                components.forEach(o -> stringBuilder.append(o.getTextMessage()));
                break;
            case LEXEME:
                components.forEach(o -> stringBuilder.append(o.getTextMessage()).append(" "));
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
        boolean result = components.add(abstractText);
        if(result){
            LOGGER.info("Component is added to: " + type);
        }
        else {
            LOGGER.info("Component is not added to: " + type);
        }
        return result;
    }
    @Override
    public boolean remove(AbstractText abstractText) {
        boolean result = components.remove(abstractText);
        if(result){
            LOGGER.info("Component is removed from: " + type);
        }
        else {
            LOGGER.info("Component is not removed from: " + type);
        }
        return result;
    }
    @Override
    public boolean removeAll() {
        components = new ArrayList<>();
        LOGGER.info("All Components are removed from: " + type);
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
            stringBuilder.append(paragraph.getTextMessage());
            stringBuilder.append("\n\t");
        }
        return stringBuilder.toString();
    }

}
