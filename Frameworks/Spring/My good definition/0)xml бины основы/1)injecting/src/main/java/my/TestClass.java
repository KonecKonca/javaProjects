package my;

public class TestClass {
    private InjectingClass injectingClass;
    public void setInjectingClass(InjectingClass injectingClass) {
        System.out.println("Setter is called (TestClass.getInjectingClass()");
        this.injectingClass = injectingClass;
    }

    public InjectingClass getInjectingClass() {
        return injectingClass;
    }
    public TestClass(InjectingClass injectingClass) {
        this.injectingClass = injectingClass;
    }
    public TestClass(){
        System.out.println("TestClass is Created");
    }

    public void test(){
        System.out.print("I am testing injecting class,\n he say: ");
        injectingClass.action();
    }
}
