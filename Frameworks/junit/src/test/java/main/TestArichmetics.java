package main;

import javafx.animation.Timeline;
import main.Arichmetics;
import org.junit.*;
import org.junit.rules.Timeout;

public class TestArichmetics {
    @Rule
    public Timeout timeout = new Timeout(101);  // аналог анннотации ниже, для всех тестов

    private static Arichmetics arichmetics;
    @BeforeClass   // однажды перед всеми тестами, @Before -- перед каждым тестом
    public static void before(){
        arichmetics = new Arichmetics();
    }

    @After  // После каждого теста  @AfterClass - единажды после всех тестов
    public void after(){
        System.out.println("После");
    }

    @Ignore   // не будет выполняться
    @Test
    public void testSum(){
        double res = arichmetics.sum(3, 7);
        Assert.assertTrue(res == 10);
    }
    @Test
    public void testDeduct(){
        double res = arichmetics.deduct(3, 7);
        Assert.assertTrue(res == -4);
    }
    @Test
    public void testMult(){
        double res = arichmetics.mult(3, 7);
        Assert.assertTrue(res == 21);
    }
    @Test
    public void testDiv() {
        double res = arichmetics.div(28, 7);
        Assert.assertTrue(res == 4);
    }
    @Test(expected = Exception.class)  //  проверка на вылет исключения(если вылетело, тест пройден)
    public void divException(){
        arichmetics.div(10.0, 0);
    }

    @Test(timeout = 100) // не вложился в 100, значит фейл теста
    public void testTme(){
        arichmetics.time();
    }

    public static void x(){}
}
