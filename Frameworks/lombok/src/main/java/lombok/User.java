package lombok;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
public class User {
    private Integer id;

    private String name;
    private String lastName;
    private String email;
    private Boolean active;
    private Date time;

}
