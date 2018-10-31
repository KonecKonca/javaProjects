package model.specification.user;

import model.specification.SQLSpecification;

public class UserByIdSpecification implements SQLSpecification {
    private final String id;

    public UserByIdSpecification(final String id) {
        this.id=id;
    }

    @Override
    public String toSqlClauses() {
        return "SELECT * from user WHERE id="+id;
    }
}
