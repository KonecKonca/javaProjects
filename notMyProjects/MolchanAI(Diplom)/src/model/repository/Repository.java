package model.repository;

import model.db.DBHelper;
import model.specification.SQLSpecification;

import java.sql.SQLException;
import java.util.List;

public interface Repository<AppEntity> {
    DBHelper db = DBHelper.getInstance();
    void add(AppEntity entity);
    void remove(AppEntity entity);
    void update(AppEntity entity);
    List<AppEntity> query(SQLSpecification specification) throws SQLException;
}
