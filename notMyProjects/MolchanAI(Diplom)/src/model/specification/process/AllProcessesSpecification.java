package model.specification.process;

import model.specification.SQLSpecification;

public class AllProcessesSpecification  implements SQLSpecification {
    @Override
    public String toSqlClauses() {
        return "SELECT * FROM process;";
    }
}
