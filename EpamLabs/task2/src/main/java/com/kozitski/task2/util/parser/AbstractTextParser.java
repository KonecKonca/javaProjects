package com.kozitski.task2.util.parser;

import com.kozitski.task2.composite.AbstractText;
import com.kozitski.task2.composite.impl.TextAll;

public interface AbstractTextParser {
    Object parse(String text);
}
