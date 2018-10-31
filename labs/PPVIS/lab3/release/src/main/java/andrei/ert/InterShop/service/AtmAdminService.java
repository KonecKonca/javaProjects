package andrei.ert.InterShop.service;

import andrei.ert.InterShop.entity.AdminData;

import java.util.List;

public interface AtmAdminService {

    boolean checkComplience(AdminData adminData);

    // COMMENTS
    List<String> getAllComments();
    void deleteComment(String comment);

}
