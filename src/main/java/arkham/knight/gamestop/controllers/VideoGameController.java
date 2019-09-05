package arkham.knight.gamestop.controllers;

import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.services.VideoGameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/videogames")
public class VideoGameController {

    @Autowired
    private VideoGameServices videoGameServices;


    @RequestMapping("/")
    public String login(Model model){

        Date date = new Date();
        VideoGame videoGame = new VideoGame("Kingdom Hears 2","Square Enix",date,"Jrpg",45.44,"1 player");

        videoGameServices.createVideoGame(videoGame);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("videogames",videoGameServices.listAllVideoGames());

        return "/freemarker/videogames";
    }
}
