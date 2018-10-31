package andrei.ert.InterShop.service;

import andrei.ert.InterShop.dao.AtmDao;
import andrei.ert.InterShop.dao.AtmDaoImpl;
import andrei.ert.InterShop.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmMainServiceImpl implements AtmMainService{

    @Autowired
    private AtmDao atmDaoImpl;

    // Comments
    public List<String> getAllComments(){
        return atmDaoImpl.getAllComments();
    }
    public void addComment(String comment){
        atmDaoImpl.addComment(comment);
    }

    // операции с балансом
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
        if(value <= atmDaoImpl.getMoney()){
            double result = atmDaoImpl.getMoney() - value;
            atmDaoImpl.setMoney(result);
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
        if(value <= atmDaoImpl.getMoney()){
            double result = atmDaoImpl.getMoney() - value;
            atmDaoImpl.setMoney(result);
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

        if(value <= atmDaoImpl.getMoney()){
            double result = atmDaoImpl.getMoney() - value;
            atmDaoImpl.setMoney(result);
            return true;
        }
        return false;
    }
    public Card getCard() {
        return atmDaoImpl.getCard();
    }
    public boolean checkComplience(Card card){
        return atmDaoImpl.checkComplience(card);
    }



}
