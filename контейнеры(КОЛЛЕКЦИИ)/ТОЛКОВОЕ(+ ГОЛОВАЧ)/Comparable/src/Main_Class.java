import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main_Class {
    public static void main(String[] args)throws Exception{
        Set<UnderTest> set = new TreeSet();
        set.add(new UnderTest(23, 4545, 3));
        set.add(new UnderTest(0, 4545, 3));
        set.add(new UnderTest(23, 1, 3));
        set.add(new UnderTest(23, 4545, 223));
        System.out.println(set);
    }
}

class UnderTest implements Comparable<UnderTest>{
    int priority1;
    double priority2;
    int priority3;

    public UnderTest(){}

    public UnderTest(int n1, double n2, int n3){
        priority1 = n1;
        priority2 = n2;
        priority3 = n3;
    }

    @Override
    public int compareTo(UnderTest o) {
        if((this.priority1 - o.priority1) == 0){
            if((this.priority2 - o.priority2) == 0){
                if((this.priority3 - o.priority3) == 0){
                    return 0;
                }
                else {
                    return this.priority3 - o.priority3;
                }
            }
            else {
                return (int) (this.priority2 - o.priority2);
            }
        }
        return this.priority1 - o.priority1;
    }

    @Override
    public String toString() {
        return  ("[" + priority1 + " " +  priority2 + " " + priority3 + "]");
    }
}
