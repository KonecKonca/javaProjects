package andrei.ert.InterShop.entity.atm;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class Card {

    private String number = "1111";
    private String password = "1111";
    private double money = 999 ;

}
