package andrei.ert.InterShop.mapper;

import andrei.ert.InterShop.entity.Comment;
import andrei.ert.InterShop.entity.product.Product;
import com.sun.xml.internal.ws.api.Component;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper  implements RowMapper<String> {
    @Override
    public String mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString("comment");
    }
}
