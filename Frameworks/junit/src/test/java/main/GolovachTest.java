package main;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class GolovachTest {

    @Parameterized.Parameters
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][]{{-3, 3}, {-2, 2}, {-1, 1}, {0, 0}, {1, 1}, {2, 2}, });
    }

    @Parameterized.Parameter(0)
    public int input;

    @Parameterized.Parameter(1)
    public int expectedResult;

    @Test
    public void test(){
        Assert.assertThat(Math.abs(input), is(expectedResult));
    }

}
