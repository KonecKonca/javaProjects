package andrei.ert.InterShop.controller;

import andrei.ert.InterShop.entity.AdminData;
import andrei.ert.InterShop.entity.Card;
import andrei.ert.InterShop.service.AtmAdminService;
import andrei.ert.InterShop.service.AtmAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AtmAdminController {

    @Autowired
    public AtmAdminService adminService;

//--------------------------------------------------------------------------------
    @GetMapping("/admin")
    public String index(){
        return "ATM_ADMIN1";
    }
    @PostMapping("/admin")
    public String atm1(@ModelAttribute("adminData")AdminData adminData){
        if (adminService.checkComplience(adminData)){
            return "redirect:/ATM_ADMIN2";
        }
        return "redirect:/ATM12/" + "You entered incorect data";
    }
//--------------------------------------------------------------------------------
    @GetMapping("/ATM_ADMIN2")
    public String atm2(Model model) {
        model.addAttribute("comments", adminService.getAllComments());
        return "ATM_ADMIN2";
    }
//--------------------------------------------------------------------------------
    @GetMapping("/ATM_ADMIN3/{comment}")
    public String atm3(@PathVariable("comment") String comment) {
        adminService.deleteComment(comment);
        return "redirect:/ATM_ADMIN2";
    }
//--------------------------------------------------------------------------------


}
