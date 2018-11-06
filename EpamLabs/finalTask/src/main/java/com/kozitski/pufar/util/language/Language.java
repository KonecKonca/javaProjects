package com.kozitski.pufar.util.language;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Language {

    public static final Locale RU_LOCALE = new Locale("ru", "RU");
    public static final ResourceBundle RU_BUNDLE = ResourceBundle.getBundle("resource", RU_LOCALE);

    public static final Locale EN_LOCALE = new Locale("en", "GB");
    public static final ResourceBundle EN_BUNDLE = ResourceBundle.getBundle("resource", EN_LOCALE);

    public static void main(String[] args) {
        System.out.println(RU_BUNDLE.getString("value"));
        System.out.println(new String(RU_BUNDLE.getString("value").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        System.out.println(EN_BUNDLE.getString("value"));


        // default
//        System.out.println(ResourceBundle.getBundle("resource").getString("value"));

    }

}
