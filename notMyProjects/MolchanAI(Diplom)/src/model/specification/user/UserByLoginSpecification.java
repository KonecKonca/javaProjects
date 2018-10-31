package model.specification.user;

import model.specification.SQLSpecification;

public class UserByLoginSpecification implements SQLSpecification {
    private final String login;
    public UserByLoginSpecification(final String login) {
        this.login=login;
    }

    @Override
    public String toSqlClauses() {
        return "SELECT * FROM user WHERE login='"+login+"'"+";";
    }
}
