package base.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository("MySQLDao")
public class MySQLDao implements UserDao {

    // для вставки в талицу юзеров вообще без SQL
    // также есть SimpleJdbcCall
    private SimpleJdbcInsert insertUser;

    // JdbcTemplate -- это упрощённый вариант с db_id:received_id, а не ? для подстановки данных
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.insertUser = new SimpleJdbcInsert(dataSource).withTableName("users").usingColumns("login", "password");
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertUsers(User user) {
        System.out.println("            " + TransactionSynchronizationManager.isActualTransactionActive());

        long numberId = insertNumber(user);

        String userSql = "INSERT INTO users VALUES(NULL, :login, :password, :status, :banStatus, :numberId)";
        MapSqlParameterSource userParams = new MapSqlParameterSource();
        userParams.addValue("login", user.getLogin());
        userParams.addValue("password", user.getPassword());
        userParams.addValue("status", user.getStatus());
        userParams.addValue("banStatus", user.isBanStatus());
        userParams.addValue("numberId", numberId);

        return jdbcTemplate.update(userSql, userParams);

    }
    @Override
    // readOnly -- для селектов оптимизация
    // timeout -- врямя закоторое если не вложимся, то будет эксцепшин
    // rolbackFor/noRolbackFor -- и указывем exception
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public long insertNumber(User user){

        System.out.println("            " + TransactionSynchronizationManager.isActualTransactionActive());

        String numberSql = "INSERT INTO numbers VALUES(NULL, :country, :operator, :number)";
        MapSqlParameterSource numberParams = new MapSqlParameterSource();
        Number number = user.getNumber();
        numberParams.addValue("country", number.getCountry());
        numberParams.addValue("operator", number.getOperator());
        numberParams.addValue("number", number.getNumber());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(numberSql, numberParams, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public Optional<User> searchUserById(long id) {
        String sgl = "SELECT login, password FROM users WHERE user_id=?";

        User user = jdbcTemplate.getJdbcOperations().queryForObject(sgl, new UserRowMapper(), id);

        return Optional.ofNullable(user);
    }

    @Override
    public List<User> searchUsersByIdRangeWithLimit(long startId, long endId, int limit) {
        String sql = "SELECT login, password FROM users WHERE user_id>=? AND user_id<=? LIMIT ?";

        return jdbcTemplate.getJdbcOperations().query(sql, new UserRowMapper(), startId, endId, limit);
    }

    private static final class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));

            return user;
        }

    }

}
