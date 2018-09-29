package andrei.ert.InterShop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class Comment {
    private int id;
    private String comment;
}
