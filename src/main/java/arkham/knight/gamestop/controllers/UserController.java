package arkham.knight.gamestop.controllers;

import arkham.knight.gamestop.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;


    @RequestMapping("/")
    public String login(Model model){

        return "/freemarker/login";
    }
}
