package andrei.ert.InterShop.dao;

import andrei.ert.InterShop.entity.AdminData;

import java.util.List;

public interface AtmAdminDao {

    AdminData getAdminData();

    // Comments
    List<String> getAllComments();
    void deleteComment(String comment);

}
