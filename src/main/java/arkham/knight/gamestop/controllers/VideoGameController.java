package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.services.VideoGameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;

@Controller
@RequestMapping("/videogames")
public class VideoGameController {

    @Autowired
    private VideoGameServices videoGameServices;


    @RequestMapping("/")
    public String index(Model model){

        Date date = new Date();
        VideoGame videoGame = new VideoGame("Kingdom Hears 2","Square Enix",date,"Jrpg",45.44,"1 player");

        videoGameServices.createVideoGame(videoGame);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("videogames",videoGameServices.listAllVideoGames());

        return "/freemarker/videogames";
    }

    @RequestMapping("/creation")
    public String creationPage(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/createVideoGame";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "name") String name,@RequestParam(name = "developer") String developer, @RequestParam(name = "genre") String genre,@RequestParam(name = "gameModes") String gameModes,@RequestParam(name = "unitsSold") Double unitsSold, @RequestParam(name = "releasedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date releasedDate){

        VideoGame videoGameToCreate =new VideoGame(name,developer,releasedDate,genre,unitsSold,gameModes);

        videoGameServices.createVideoGame(videoGameToCreate);

        return "redirect:/videogames/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/editVideoGame";
    }

    @RequestMapping("/edit")
    public String edit(){

        return "redirect:/videogames/";
    }


    @RequestMapping("/show")
    public String showPage(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/showVideoGame";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "idVideoGame") long idVideoGame ){

        VideoGame videoGameToDelete = videoGameServices.findVideoGameById(idVideoGame);

        videoGameServices.deleteVideoGame(videoGameToDelete);

        return "redirect:/videogames/";
    }
}
