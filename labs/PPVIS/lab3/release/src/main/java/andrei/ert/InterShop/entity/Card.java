package andrei.ert.InterShop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class Card {

    private int id;
    private String number;
    private String password;
    private double money;

}
