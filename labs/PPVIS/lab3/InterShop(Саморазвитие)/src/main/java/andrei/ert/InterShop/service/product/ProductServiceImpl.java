package andrei.ert.InterShop.service.product;

import andrei.ert.InterShop.dao.product.ProductDao;
import andrei.ert.InterShop.entity.product.Product;
import andrei.ert.InterShop.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    public ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }
}
