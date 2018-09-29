package andrei.ert.InterShop.dao;

import andrei.ert.InterShop.entity.AdminData;
import andrei.ert.InterShop.insteadDB.AdminAttributes;
import andrei.ert.InterShop.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AtmAdminDaoImpl implements AtmAdminDao{

    public final JdbcTemplate jdbcTemplate;
    @Autowired
    public AtmAdminDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    AtmDao atmDaoImpl;

    @Override
    public AdminData getAdminData() {
        return AdminAttributes.getAdminData();
    }

    // COMMENTS
    @Override
    public List<String> getAllComments(){
        return atmDaoImpl.getAllComments();
    }
    @Override
    public void deleteComment(String comment) {
        String sql = "DELETE FROM comments WHERE comment=?";
        jdbcTemplate.update(sql, comment);
    }
}
