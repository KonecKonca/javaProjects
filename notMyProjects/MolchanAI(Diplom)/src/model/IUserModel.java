package model;

import model.entity.User;
import model.repository.ProcessRepository;
import model.repository.UserRepository;

public interface IUserModel {
    UserRepository userRepo=new UserRepository();
    User pullUser();
}
