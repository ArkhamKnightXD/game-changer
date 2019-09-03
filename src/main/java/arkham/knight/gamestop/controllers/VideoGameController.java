package arkham.knight.gamestop.controllers;

import arkham.knight.gamestop.services.VideoGameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/videogames")
public class VideoGameController {

    @Autowired
    private VideoGameServices videoGameServices;


    @RequestMapping("/")
    public String login(Model model){

        return "/freemarker/login";
    }
}
