package andrei.ert.InterShop.dao.user;

import andrei.ert.InterShop.entity.User;
import andrei.ert.InterShop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    public final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM USER";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE user_id=?";
        jdbcTemplate.update(sql, id);
    }
    @Override
    public void save(User user) {
        String sql = "INSERT INTO user values(NULL, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getAccess());
    }
    @Override
    public void update(User user) {
        String sql = "UPDATE user SET name=?, email=?, age=? WHERE user_id=?";
        jdbcTemplate.update(sql,  user.getName(), user.getEmail(), user.getAge(), user.getId());
    }
    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM user WHERE user_id=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }
}
