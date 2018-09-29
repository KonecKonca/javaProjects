package andrei.ert.InterShop.service;

import andrei.ert.InterShop.entity.Card;

import java.util.List;

public interface AtmMainService {

    // Comments
    List<String> getAllComments();
    void addComment(String comment);

    // операции с балансом
    boolean payForMobile(String sumForPay, String nomber);
    boolean payForErip(String sumForPayErip, String eripNomber);
    boolean getMoney(String inputSum);
    Card getCard();
    boolean checkComplience(Card card);

}
