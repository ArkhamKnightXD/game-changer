package arkham.knight.gamestop.controllers;

import arkham.knight.gamestop.services.ConsoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/consoles")
public class ConsoleController {

    @Autowired
    private ConsoleServices consoleServices;

    @RequestMapping("/")
    public String login(Model model){

        return "/freemarker/login";
    }
}
