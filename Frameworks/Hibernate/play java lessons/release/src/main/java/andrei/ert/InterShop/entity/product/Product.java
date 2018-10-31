package andrei.ert.InterShop.entity.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {

    private int product_id;
    private String name = "default";
    private String description = "default";

    private String category = "default";
    private int price = 0;
    private double rate = 0;
}

