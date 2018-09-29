package my;

// наследование тут не обязательно, достаточно просто фактического совпадения именований
public class TestChild {
    private String additional;
    public String getAdditional() {
        return additional;
    }
    public void setAdditional(String additional) {
        this.additional = additional;
    }

    private InjectingClass injectingClass;
    public void setInjectingClass(InjectingClass injectingClass) {
        System.out.println("Setter is called (TestClass.getInjectingClass()");
        this.injectingClass = injectingClass;
    }

    public InjectingClass getInjectingClass() {
        return injectingClass;
    }
    public TestChild(InjectingClass injectingClass) {
        this.injectingClass = injectingClass;
    }
    public TestChild(){
        System.out.println("TestClass is Created");
    }

    public void test(){
        System.out.print("I am testing injecting class,\n he say: ");
        injectingClass.action();
        System.out.println("ANYSING ELSE : " + additional);
    }

}
