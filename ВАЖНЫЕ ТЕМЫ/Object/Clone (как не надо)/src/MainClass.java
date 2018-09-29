public class MainClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        UnderTest underTest1 = new UnderTest(111, 222);
        System.out.println(underTest1);

        UnderTest underTest2 = (UnderTest)underTest1.clone();
        System.out.println(underTest2);
        underTest2.x.setS("111111111111111");

        System.out.println("\n-----------------------------\n");

        System.out.println(underTest1);
        System.out.println(underTest2);
    }
}

class X{
    private String s;

    public X(String s) {
        this.s = s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "X{" +
                "s='" + s + '\'' +
                '}';
    }
}

class UnderTest implements Cloneable{
    int a = 5;
    X x = new X("XxxX");

    public UnderTest(int a, int b) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "{ " + a + " : " + x.toString() + " }";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
