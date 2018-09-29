package model;

import model.entity.User;
import model.repository.UserRepository;
import model.specification.user.UserByLoginSpecification;

import java.util.List;

public class Authorization {
    public boolean auth(String login,String password){
        if (password!=null) {
            UserRepository repo=new UserRepository();
            List<User> users=repo.query(new UserByLoginSpecification(login));
            if(!users.isEmpty()){
                String dbHash = users.get(0).getPassword();
                return new Encryptor().getMD5(password).equals(dbHash);
            }
            //check user per login in db
           // String dbHash = "";
            //return getMD5(password).equals(dbHash);
           // return true;
        }
        return false;
    }


}
