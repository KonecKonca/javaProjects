import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImmutableCollectionsTest {

    @Test
    public void withoutGuava(){

        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");

        ArrayList<String> list1 = new ArrayList<String>(){{
            add("1");
            add("2");
            add("3");
        }};

        System.out.println(list);
        System.out.println(list1);
    }

    @Test
    public void guavaList(){

        List<String> list = ImmutableList.of("1", "2", "3");
        System.out.println(list);

        ImmutableList.Builder<String> builder = ImmutableList.builder();
        builder.add("243");
        builder.add("666");
        List<String> list1 = builder.build();
        System.out.println(list1);

    }

    @Test
    public void guavaMap(){

        Map<String, String> map = ImmutableMap.of("1", "1", "2", "2");
        System.out.println(map);

    }

}
