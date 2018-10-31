package model.specification.user;

import model.specification.SQLSpecification;

public class UserByNameSpecification implements SQLSpecification {
    private final String name;

    public UserByNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public String toSqlClauses() {
        return  "SELECT * FROM user WHERE name='"+name+"'"+";";
    }
}
