import java.util.Objects;

public class Fisics{
    private String definition;
    public Fisics(String definition) {
        this.definition = definition;
    }
    public String getDefinition() {
        return definition;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder  = new StringBuilder();
        for(int i = 0; (i < 3) && (i < definition.length()); i++){
            stringBuilder.append(definition.charAt(i));
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fisics)) return false;
        Fisics fisics = (Fisics) o;
        return Objects.equals(getDefinition(), fisics.getDefinition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDefinition());
    }
}
