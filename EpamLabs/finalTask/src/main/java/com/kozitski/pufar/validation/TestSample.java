package com.kozitski.pufar.validation;

import com.kozitski.pufar.validation.annotation.AspectValid;
import com.kozitski.pufar.validation.annotation.StringValid;

public class TestSample {

    public static void main(String[] args) {

        fasad();

    }

    public static void fasad(){
        UnderTest test = new UnderTest();

        System.out.println("--------------------------------------------------");
        test.method1();
        System.out.println("--------------------------------------------------");

        test.method2("InputString");
        System.out.println("--------------------------------------------------");

        test.method3("InputString1", "InputString2");
        System.out.println("--------------------------------------------------");

        test.method4(434, "InputString", new Object());
        System.out.println("--------------------------------------------------");

        UnderTest.method5();
        System.out.println("--------------------------------------------------");

        UnderTest.method6("I1", "InputString2", 67.3);
        System.out.println("--------------------------------------------------");
    }

}


class UnderTest{

    public void method1(){
        System.out.println("==> method1");
    }


    public void method2(String string){
        System.out.println("==> method2: " + string);
    }

    @AspectValid
    public void method3(@StringValid(forbiddenValue = "InputString2") String string1, @StringValid String string2){
        System.out.println("==> method3: " + string1 + " " + string2);
    }

    @AspectValid
    public void method4(Integer integer, @StringValid String string, Object object){
        System.out.println("==> method4: " + integer + " " + string + " " + object);
    }

    public static void method5(){
        System.out.println("==> method5");
    }

    @AspectValid
    public static void method6(@StringValid String string1,@StringValid String string2, Double doubleValue){
        System.out.println("==> method6: " + string1 + " " + string2 + " " + doubleValue);
    }



}