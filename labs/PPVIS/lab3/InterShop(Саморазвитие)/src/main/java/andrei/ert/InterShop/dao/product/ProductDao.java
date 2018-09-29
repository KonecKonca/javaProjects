package andrei.ert.InterShop.dao.product;

import andrei.ert.InterShop.entity.User;
import andrei.ert.InterShop.entity.product.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    Product getById(int id);
}
