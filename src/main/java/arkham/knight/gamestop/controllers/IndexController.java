package arkham.knight.gamestop.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/index";
    }

    @RequestMapping("/admin")
    public String admin(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/adminPage";
    }

}
