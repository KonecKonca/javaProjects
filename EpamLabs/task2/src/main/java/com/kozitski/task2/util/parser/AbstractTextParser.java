package com.kozitski.task2.util.parser;

import com.kozitski.task2.composite.AbstractText;

@FunctionalInterface
public interface AbstractTextParser {
    AbstractText parse(String text);
}
