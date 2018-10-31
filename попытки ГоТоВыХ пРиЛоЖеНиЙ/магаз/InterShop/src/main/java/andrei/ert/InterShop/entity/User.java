package andrei.ert.InterShop.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private int id;
    private int age;
    private String name;
    private String email;
    private String access = "u00";

}
