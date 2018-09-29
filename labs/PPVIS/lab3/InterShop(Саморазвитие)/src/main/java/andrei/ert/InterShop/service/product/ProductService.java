package andrei.ert.InterShop.service.product;

import andrei.ert.InterShop.entity.User;
import andrei.ert.InterShop.entity.product.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product getById(int id);
}
