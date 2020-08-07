package kz.rakhat.shop.web;


import kz.rakhat.shop.model.Product;
import kz.rakhat.shop.model.PurchasedProducts;
import kz.rakhat.shop.model.User;
import kz.rakhat.shop.repository.ProductRepository;
import kz.rakhat.shop.repository.PurchRepo;
import kz.rakhat.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PurchRepo purchRepo;



    @GetMapping("/")
    public String root() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


    @GetMapping("/user")
    public String userIndex() {
        return "user/home";
    }

    @GetMapping("/order")
    public String orderPage(){
        return "order";
    }

    @PostMapping("/order")
    public String queryOrderingProduct(Authentication authentication, @RequestParam String name){
        Product existing = productRepository.findByName(name);


        if (existing==null){
            return "redirect:/order?error";
        }

        authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        PurchasedProducts purchasedProduct = new PurchasedProducts(currentPrincipalName , name);
        purchRepo.save(purchasedProduct);

        return "redirect:/order?success";
    }
}
