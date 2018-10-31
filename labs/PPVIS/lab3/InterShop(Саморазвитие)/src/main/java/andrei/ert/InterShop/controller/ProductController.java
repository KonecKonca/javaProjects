package andrei.ert.InterShop.controller;

import andrei.ert.InterShop.service.product.ProductService;
import andrei.ert.InterShop.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/allProducts")
    public String allProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "WW_AllProducts";
    }

    @GetMapping("/product/{id}")
    public String getOneProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "WW_OneProduct";
    }

    @GetMapping("/myInfo")
    public String myInfo(){
        return "WW_UserInfo";
    }

}
