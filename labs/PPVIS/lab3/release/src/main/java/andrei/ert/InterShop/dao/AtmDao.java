package andrei.ert.InterShop.dao;

import andrei.ert.InterShop.entity.Card;

import java.util.List;

public interface AtmDao {

    // COMMENTS
    List<String> getAllComments();
    void addComment(String comment);

    // CARDS
    boolean checkComplience(Card card);
    Card getCard();
    void setMoney(double value);
    double getMoney();

}
