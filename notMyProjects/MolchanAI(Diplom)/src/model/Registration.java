package model;

import model.entity.User;
import model.repository.UserRepository;

public class Registration {
    private int minLoginLength=5;
    private int maxLoginLength=10;
    private int minPasswordLength=7;
    private int maxPasswordLength=14;

    private UserRepository repo=new UserRepository();

    public boolean isLoginCorrect(String login){
       // repo.query(new AllUsersSpecification());
        //check if in db exist this login
        if(login.length()<minLoginLength)
            return false;
        if(login.length()>maxLoginLength)
            return false;
        return true;
    }

    public boolean isPasswordCorrect(String password){
        if(password.length()<minPasswordLength)
            return false;
        return password.length() <= maxPasswordLength;
    }

    public boolean isNameCorrect(String name, String surname){
       return true;
    }

    public void register(String login, String password, String name,String surname){
        User user=new User();
        user.setLogin(login);
        Encryptor encr=new Encryptor();
        user.setPassword(encr.getMD5(password));
        user.setName(name);
        user.setSurname(surname);
        repo.add(user);
        //new Authorization().auth(login,password);
    }

    public int getMinLoginLength() {
        return minLoginLength;
    }

    public int getMaxLoginLength() {
        return maxLoginLength;
    }

    public int getMinPasswordLength() {
        return minPasswordLength;
    }

    public int getMaxPasswordLength() {
        return maxPasswordLength;
    }
}
