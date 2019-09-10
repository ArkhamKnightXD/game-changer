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

    @RequestMapping("/showHomeConsole")
    public String showHomeConsoleDescription(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/homeConsoleInfo";
    }

    @RequestMapping("/showHandheldConsole")
    public String showHandheldConsoleDescription(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/handheldConsoleInfo";
    }


    @RequestMapping("/showVideogame")
    public String showVideogameDescription(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/videogameInfo";
    }
}
