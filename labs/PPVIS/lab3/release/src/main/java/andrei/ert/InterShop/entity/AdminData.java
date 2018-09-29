package andrei.ert.InterShop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class AdminData {
    private String adminName;
    private String password;

    public AdminData(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }
}
