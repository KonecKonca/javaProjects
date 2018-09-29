package andrei.ert.InterShop.mapper;

import andrei.ert.InterShop.entity.Card;
import andrei.ert.InterShop.entity.product.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardMapper  implements RowMapper<Card> {
    @Override
    public Card mapRow(ResultSet resultSet, int i) throws SQLException {
        Card card = new Card();

        card.setId(resultSet.getInt("id"));
        card.setNumber(resultSet.getString("nomber"));
        card.setPassword(resultSet.getString("password"));
        card.setMoney(resultSet.getDouble("money"));

        return card;
    }
}
