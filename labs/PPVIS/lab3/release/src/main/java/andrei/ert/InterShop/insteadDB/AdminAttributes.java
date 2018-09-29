package andrei.ert.InterShop.insteadDB;

import andrei.ert.InterShop.entity.AdminData;

public class AdminAttributes {
    public static final String adminName = "admin";
    public static final String password = "root";

    public static AdminData getAdminData(){
        return new AdminData(adminName, password);
    }
}
