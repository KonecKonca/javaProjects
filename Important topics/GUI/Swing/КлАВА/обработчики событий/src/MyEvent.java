import java.util.EventObject;

public class MyEvent extends EventObject{
    private Type type = Type.TYPE_1;

    public MyEvent(Object source, Type type){
        super(source);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type){
        this.type = type;
    }

    public enum Type{
        TYPE_1, TYPE_2;
    }
}
