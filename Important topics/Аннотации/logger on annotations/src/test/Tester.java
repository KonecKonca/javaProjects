package test;

import annologger.DefaultLoggingPolicy;
import annologger.ITestInterface;

@LoggingPolicyAnnotation(loggingPolicy = DefaultLoggingPolicy.class)
public class Tester implements ITestInterface {

    @LoggingAnnotation(logLevel = LogLevel.High)
    public int addition(int a, int b)
    {
        return a + b;
    }

    @LoggingAnnotation(logLevel = LogLevel.Low)
    public int difference(int a, int b)
    {
        return a - b;
    }

    public int multiplication(int a, int b)
    {
        return a * b;
    }

    @LoggingAnnotation(logLevel = LogLevel.High)
    public int quotient(int a, int b) {
        return a / b;
    }

}