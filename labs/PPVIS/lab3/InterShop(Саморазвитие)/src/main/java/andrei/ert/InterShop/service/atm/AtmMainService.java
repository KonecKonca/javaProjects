package andrei.ert.InterShop.service.atm;

import andrei.ert.InterShop.dao.atm.AtmDao;
import andrei.ert.InterShop.entity.atm.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmMainService {

    @Autowired
    private AtmDao atmDao;

    public Card getCard() {
        return atmDao.getCard();
    }
    public boolean checkComplience(Card card){
        return atmDao.checkComplience(card);
    }
    public List<String> getAllComments(){
        return atmDao.getAllComments();
    }
    public void addComment(String comment){
        atmDao.addComment(comment);
    }

    // операции снятия денег
    public boolean payForMobile(String sumForPay, String nomber){
        if(sumForPay.equals("") || nomber.equals("")){
            return false;
        }
        if(nomber.length() != 9){
            return false;
        }

        double value;
        try {
            Double.parseDouble(nomber);
            value = Double.parseDouble(sumForPay);
        }
        catch (Exception ex){
            return false;
        }
        if(value <= atmDao.getMoney()){
            double result = atmDao.getMoney() - value;
            atmDao.setMoney(result);
            return true;
        }
        return false;
    }
    public boolean payForErip(String sumForPayErip, String eripNomber){
        if(sumForPayErip.equals("") || eripNomber.equals("")){
            return false;
        }

        double value;
        try {
            Double.parseDouble(eripNomber);
            value = Double.parseDouble(sumForPayErip);
        }
        catch (Exception ex){
            return false;
        }
        if(value <= atmDao.getMoney()){
            double result = atmDao.getMoney() - value;
            atmDao.setMoney(result);
            return true;
        }
        return false;
    }
    public boolean getMoney(String inputSum){
        if(inputSum.equals("")){
            return false;
        }

        double value = 1;
        try {
            value = Double.parseDouble(inputSum);
        }
        catch (Exception ex){
            return false;
        }
        if((value % 10) != 0){
            return false;
        }

        if(value <= atmDao.getMoney()){
            double result = atmDao.getMoney() - value;
            atmDao.setMoney(result);
            return true;
        }
        return false;
    }

}
