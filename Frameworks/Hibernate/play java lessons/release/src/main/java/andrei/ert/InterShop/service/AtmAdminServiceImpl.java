package andrei.ert.InterShop.service;

import andrei.ert.InterShop.dao.AtmAdminDao;
import andrei.ert.InterShop.entity.AdminData;
import andrei.ert.InterShop.insteadDB.AdminAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmAdminServiceImpl implements AtmAdminService{

    @Autowired
    AtmAdminDao atmAdminDao;

    @Override
    public boolean checkComplience(AdminData adminData) {
        if(atmAdminDao.getAdminData().getAdminName().equalsIgnoreCase(adminData.getAdminName()) &&
                atmAdminDao.getAdminData().getPassword().equalsIgnoreCase(adminData.getPassword())){
            return true;
        }
        return false;
    }

    // COMMENTS
    @Override
    public List<String> getAllComments() {
        return atmAdminDao.getAllComments();
    }
    @Override
    public void deleteComment(String comment) {
        atmAdminDao.deleteComment(comment);
    }
}
