package test;

import annologger.ITestInterface;
import annologger.LoggerFactory;

public class MainClass
{

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ITestInterface tester = new Tester();
        Object obj = LoggerFactory.createLogObject(tester, System.out);
        ITestInterface loggedTester = (ITestInterface) obj;

        loggedTester.addition(1, 6);
        loggedTester.difference(6, 2);
        loggedTester.multiplication(43, 453);


        try
        {
            loggedTester.quotient(343,5);
            loggedTester.quotient(343, 0);
        }
        catch(Exception e)
        {
            // filter for all exception to show that log works fine

        }



    }

}
