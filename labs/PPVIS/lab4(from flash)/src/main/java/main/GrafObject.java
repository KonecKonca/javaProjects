package main;

import lombok.*;
import main.library.Grafable;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
public class GrafObject implements Grafable {
    private String data = "2334r34343";
    private int id = 666;
    private Set<Integer> list = new HashSet<>(Arrays.asList(34, 43 , 434));

    @Override
    public int id() {
        return id;
    }
    @Override
    public Set<Integer> Allconected() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        GrafObject grafObject = (GrafObject) o;
        if(grafObject.data.equals(this.data)){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getData(), getId(), getList());
    }

    @Override
    public String toString() {
        return data;
    }
}
