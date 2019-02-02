import com.google.common.base.Preconditions;
import org.springframework.util.StringUtils;

import org.testng.annotations.Test;

public class PreconditionsTest{


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testPreconditions1() throws IllegalArgumentException{
        receivedArgMethod("", 1);
    }
    @Test(expectedExceptions = NullPointerException.class)
    public void testPreconditions2() throws NullPointerException{
        receivedArgMethod("2345", null);
    }
    @Test
    public void testPreconditions3(){
        receivedArgMethod("23", 1);
    }

    private void receivedArgMethod(String message, Integer integer){

        Preconditions.checkArgument(!StringUtils.isEmpty(message), "Message can not be empty");
        Preconditions.checkNotNull(integer, "can not be null");

    }

}
