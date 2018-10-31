package model;

import model.entity.Process;

public interface IParentWindow<AppEntity> {
    void updateProcess(AppEntity entity);
    void deleteProcess(AppEntity entity);
    void addProcess(AppEntity entity);
}
