package andrei.ert.InterShop.controller.atm;

import andrei.ert.InterShop.entity.User;
import andrei.ert.InterShop.entity.atm.Card;
import andrei.ert.InterShop.service.atm.AtmMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AtmMainController {

    @Autowired
    public AtmMainService atmMainService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
//-----------------------------------------------------------------------------------------------------------
    @GetMapping("/ATM1")
    public String atm1(){
        return "ATM1";
    }
    @PostMapping("/ATM1")
    public String atm1(@ModelAttribute("card")Card card){
        if (atmMainService.checkComplience(card)){
            return "redirect:/ATM2";  // перекидываем на другой обработчик с указанным маппингом
        }
        return "redirect:/ATM12/" + "You entered incorect data";
    }
// -----------------------------------------------------------------------------------------------------------
    @GetMapping("/ATM2")
    public String atm2(@ModelAttribute("card")Card card){
        return "ATM2";
    }
//-----------------------------------------------------------------------------------------------------------

    @GetMapping("/ATM3")
    public String atm3(){
        return "ATM3";
    }
//    -----------------------------------------------------------------------------------------------------------
    @GetMapping("/ATM4")
    public String atm4(){
        return "ATM4";
    }
    @PostMapping("/ATM4")
    public String atm4(@ModelAttribute("comment")String comment){
        atmMainService.addComment(comment);
        return "redirect:/ATM10";
    }
//-----------------------------------------------------------------------------------------------------------
    @GetMapping("/ATM5")
    public String atm5(){
        return "ATM5";
    }
    @PostMapping("/ATM5")
    public String atm5(@ModelAttribute("sumForPayErip")String sumForPayErip, @ModelAttribute("eripNomber") String eripNomber){
        if(atmMainService.payForErip(sumForPayErip, eripNomber)){
            return "redirect:/ATM12/" + "Payment by ERIP nomber: " + eripNomber + " completed successfully";
        }
        return "redirect:/ATM12/" + "You have not money, or write incorect data";
    }
//-----------------------------------------------------------------------------------------------------------
    @GetMapping("/ATM6")
    public String atm6(Model model){
        model.addAttribute("card", atmMainService.getCard());
        return "ATM6";
    }
//-----------------------------------------------------------------------------------------------------------
    @GetMapping("/ATM7")
    public String atm7(){
        return "ATM7";
    }
    @PostMapping("/ATM7")
    public String atm7(@ModelAttribute("inputSum") String inputSum){
        if(atmMainService.getMoney(inputSum)){
            return "redirect:/ATM8";
        }
        return "redirect:/ATM12/" + "You have not money, or write incorect data";
    }
    @PostMapping("/ATM7_1")
    public String atm7_1(){
        if(atmMainService.getMoney("10")){
            return "redirect:/ATM8";
        }
        return "redirect:/ATM12/" + "You have not money, or write incorect data";
    }
    @PostMapping("/ATM7_2")
    public String atm7_2(){
        if(atmMainService.getMoney("50")){
            return "redirect:/ATM8";
        }
        return "redirect:/ATM12/" + "You have not money, or write incorect data";
    }
    @PostMapping("/ATM7_3")
    public String atm7_3(){
        if(atmMainService.getMoney("20")){
            return "redirect:/ATM8";
        }
        return "redirect:/ATM12/" + "You have not money, or write incorect data";
    }
    @PostMapping("/ATM7_4")
    public String atm7_4(@ModelAttribute("inputSum") String inputSum){
        if(atmMainService.getMoney("100")){
            return "redirect:/ATM8";
        }
        return "redirect:/ATM12/" + "You have not money, or write incorect data";
    }
//-----------------------------------------------------------------------------------------------------------
    @GetMapping("/ATM8")
    public String atm8(){
        return "ATM8";
    }
//-----------------------------------------------------------------------------------------------------------
    @GetMapping("/ATM10")
    public String atm10(Model model){
        model.addAttribute("comments", atmMainService.getAllComments());
        return "ATM10";
    }
//-----------------------------------------------------------------------------------------------------------
    @GetMapping("/ATM11")
    public String atm11(){
        return "ATM11";
    }
    @PostMapping("/ATM11")
    public String atm11(@ModelAttribute("sumForPay")String sumForPay, @ModelAttribute("nomber") String nomber){
        if(atmMainService.payForMobile(sumForPay, nomber)){
            return "redirect:/ATM12/" + "Payment completed successfully";
        }
        return "redirect:/ATM12/" + "You have not money, or write incorect data";
    }
//-----------------------------------------------------------------------------------------------------------
    @GetMapping("/ATM12/{data}")
    public String atm12(@PathVariable("data") String data, Model model){
        model.addAttribute("data", data);
        return "ATM12";
    }
//-----------------------------------------------------------------------------------------------------------
}
