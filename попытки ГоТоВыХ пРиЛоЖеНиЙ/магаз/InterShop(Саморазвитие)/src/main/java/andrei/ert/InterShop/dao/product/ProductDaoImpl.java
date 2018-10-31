package andrei.ert.InterShop.dao.product;

import andrei.ert.InterShop.entity.User;
import andrei.ert.InterShop.entity.product.Product;
import andrei.ert.InterShop.mapper.ProductMapper;
import andrei.ert.InterShop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    public final JdbcTemplate jdbcTemplate;
    @Autowired
    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public Product getById(int id) {
        String sql = "SELECT * FROM product WHERE product_id=?";
        return jdbcTemplate.queryForObject(sql, new ProductMapper(), id);
    }
}
