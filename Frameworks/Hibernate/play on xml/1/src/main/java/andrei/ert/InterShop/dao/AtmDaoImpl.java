package andrei.ert.InterShop.dao;

import andrei.ert.InterShop.entity.Card;
import andrei.ert.InterShop.entity.Comment;
import andrei.ert.InterShop.insteadDB.Comments;
import andrei.ert.InterShop.mapper.CardMapper;
import andrei.ert.InterShop.mapper.CommentMapper;
import andrei.ert.InterShop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AtmDaoImpl implements AtmDao{

    public final JdbcTemplate jdbcTemplate;
    @Autowired
    public AtmDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // COMMENTS
    public List<String> getAllComments(){
        String sql = "SELECT comment FROM comments";
        List<String> list = jdbcTemplate.query(sql, new CommentMapper());
        List<String> result = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--){
            result.add(list.get(i));
        }
        return result;
    }
    public void addComment(String comment){
        String sql = "INSERT INTO comments VALUES(NULL, ?)";
        jdbcTemplate.update(sql, comment);
    }


    // CARD
    private Card DBCard;
    public boolean checkComplience(Card card){
        String sql = "SELECT * FROM cards WHERE nomber=?";
        try{
            DBCard = jdbcTemplate.queryForObject(sql, new CardMapper(), card.getNumber());
        }
        catch (Exception e){
            return false;
        }

        if(DBCard == null){
            return false;
        }

        if(DBCard.getPassword().equalsIgnoreCase(card.getPassword())){
            return true;
        }
        return false;
    }
    public Card getCard(){
        String nomber = DBCard.getNumber();

        String sql = "SELECT * FROM cards WHERE nomber=?";
        Card DBCard = jdbcTemplate.queryForObject(sql, new CardMapper(), nomber);

        return DBCard;
    }
    public void setMoney(double value){
        DBCard.setMoney(value);

        String sql = "UPDATE cards SET money=? WHERE id=?";
        jdbcTemplate.update(sql, DBCard.getMoney(), DBCard.getId());
    }
    public double getMoney(){
        return DBCard.getMoney();
    }


}
