package andrei.ert.InterShop.mapper;

import andrei.ert.InterShop.entity.User;
import andrei.ert.InterShop.entity.product.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProduct_id(resultSet.getInt("product_id"));
        product.setCategory(resultSet.getString("category"));
        product.setDescription(resultSet.getString("description"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getInt("price"));
        product.setRate(resultSet.getDouble("rate"));

        return product;
    }

}
