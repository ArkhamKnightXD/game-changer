package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.services.FileUploadServices;
import arkham.knight.gamestop.services.VideoGameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;

@Controller
@RequestMapping("/videogames")
public class VideoGameController {

    @Autowired
    private VideoGameServices videoGameServices;

    @Autowired
    private FileUploadServices fileUploadServices;

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/bootstrap-4.3.1/assets/img";


    @RequestMapping("/")
    public String index(Model model){

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
    public String create(@RequestParam(name = "name") String name,@RequestParam(name = "developer") String developer, @RequestParam(name = "genre") String genre,@RequestParam(name = "gameModes") String gameModes,@RequestParam(name = "unitsSold") Double unitsSold, @RequestParam(name = "releasedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date releasedDate,@RequestParam(name = "image") MultipartFile[] image){

        String imageName = fileUploadServices.almacenarAndDepurarImagen(image,uploadDirectory);

        VideoGame videoGameToCreate =new VideoGame(name,developer,releasedDate,genre,unitsSold,gameModes,imageName);

        videoGameServices.createVideoGame(videoGameToCreate);

        return "redirect:/videogames/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model, @RequestParam(name = "id") Long id){

        VideoGame videoGameToEdit = videoGameServices.findVideoGameById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("videogame",videoGameToEdit);

        return "/freemarker/editVideoGame";
    }

    @RequestMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") Long id, @RequestParam(name = "name") String name,@RequestParam(name = "developer") String developer, @RequestParam(name = "genre") String genre,@RequestParam(name = "gameModes") String gameModes,@RequestParam(name = "unitsSold") Double unitsSold, @RequestParam(name = "releasedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date releasedDate,@RequestParam(name = "image") MultipartFile[] image){

        String imageName = fileUploadServices.almacenarAndDepurarImagen(image,uploadDirectory);

        VideoGame videoGameToEdit = videoGameServices.findVideoGameById(id);

        videoGameToEdit.setName(name);
        videoGameToEdit.setDeveloper(developer);
        videoGameToEdit.setGenre(genre);
        videoGameToEdit.setReleasedDate(releasedDate);
        videoGameToEdit.setGameModes(gameModes);
        videoGameToEdit.setUnitsSold(unitsSold);
        videoGameToEdit.setImage(imageName);

        videoGameServices.createVideoGame(videoGameToEdit);

        model.addAttribute("title","Welcome to the game store");
        return "redirect:/videogames/showVideogame/";
    }


    @RequestMapping("/show")
    public String showPage(Model model, @RequestParam(name = "id") Long id){

        VideoGame videoGameToShow = videoGameServices.findVideoGameById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("videogame",videoGameToShow);

        return "/freemarker/showVideoGame";
    }

    @RequestMapping("/showVideogame")
    public String showVideogameDescription(Model model){

        model.addAttribute("title","Welcome to the game store");

        model.addAttribute("videogames",videoGameServices.listAllVideoGames());

        return "/freemarker/videogameInfo";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "idVideoGame") long idVideoGame ){

        VideoGame videoGameToDelete = videoGameServices.findVideoGameById(idVideoGame);

        videoGameServices.deleteVideoGame(videoGameToDelete);

        return "redirect:/videogames/";
    }
}
