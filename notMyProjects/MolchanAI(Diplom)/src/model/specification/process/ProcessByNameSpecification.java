package model.specification.process;

import model.specification.SQLSpecification;

public class ProcessByNameSpecification implements SQLSpecification {
    private final String name;

    public ProcessByNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public String toSqlClauses() {
        return  "SELECT * FROM process WHERE name='"+name+"'"+";";
    }
}
