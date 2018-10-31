package model;

import model.entity.Process;
import model.repository.ProcessRepository;
import model.repository.UserRepository;

public interface IProsessModel {
     ProcessRepository procRepo=new ProcessRepository();
    UserRepository userRepo=new UserRepository();
     void pushProcess();
}
