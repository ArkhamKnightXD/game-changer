package arkham.knight.gamestop.controllers;

import arkham.knight.gamestop.models.User;
import arkham.knight.gamestop.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/Users";
    }

    @RequestMapping("/creation")
    public String creationPage(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/createUser";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(){

        return "redirect:/users/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/editUser";
    }

    @RequestMapping("/edit")
    public String edit(){

        return "redirect:/users/";
    }



    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "idUser") Long idUser){

        User userToDelete = userServices.findUserById(idUser);

        userServices.deleteUser(userToDelete);

        return "redirect:/users/";
    }
}
