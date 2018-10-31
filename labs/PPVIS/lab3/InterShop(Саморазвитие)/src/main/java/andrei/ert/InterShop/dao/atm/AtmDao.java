package andrei.ert.InterShop.dao.atm;

import andrei.ert.InterShop.entity.atm.Card;
import andrei.ert.InterShop.insteadDB.Comments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtmDao {

    private Card card = new Card();

    public Card getCard(){
        return card;
    }
    public boolean checkComplience(Card card){
        if(this.card.getNumber().equalsIgnoreCase(card.getNumber()) && this.card.getPassword().equalsIgnoreCase(card.getPassword())){
            return true;
        }
        return false;
    }
    public List<String> getAllComments(){
        return Comments.getList();
    }
    public void addComment(String comment){
        Comments.addComment(comment);
    }

    public void setMoney(double value){
        card.setMoney(value);
    }
    public double getMoney(){
        return card.getMoney();
    }

}
