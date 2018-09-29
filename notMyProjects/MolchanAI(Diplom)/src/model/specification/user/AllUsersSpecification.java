package model.specification.user;

import model.specification.SQLSpecification;

public class AllUsersSpecification implements SQLSpecification {

    @Override
    public String toSqlClauses() {
        return "SELECT * from user;";
    }
}
