package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.services.ConsoleServices;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/videogames")
public class VideoGameController {

    @Autowired
    private VideoGameServices videoGameServices;

    @Autowired
    private ConsoleServices consoleServices;

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
        model.addAttribute("consoles", consoleServices.listAllConsoles());

        return "/freemarker/createVideoGame";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "idConsoles") List<Long> idConsoles, @RequestParam(name = "name") String name, @RequestParam(name = "developer") String developer, @RequestParam(name = "genre") String genre, @RequestParam(name = "gameModes") String gameModes, @RequestParam(name = "unitsSold") Double unitsSold, @RequestParam(name = "releasedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date releasedDate, @RequestParam(name = "rating") float rating, @RequestParam(name = "image") MultipartFile[] image){

        String imageName = fileUploadServices.almacenarAndDepurarImagen(image,uploadDirectory);

        List<Console> consoleList = new ArrayList<>();

        for (Long consoles: idConsoles
             ) {

            Console consolesToAdd = consoleServices.findConsoleById(consoles);

            consoleList.add(consolesToAdd);
            
        }

        VideoGame videoGameToCreate =new VideoGame(name,developer,releasedDate,genre,unitsSold,gameModes,rating,imageName,consoleList);

        videoGameServices.createVideoGame(videoGameToCreate);

        return "redirect:/videogames/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model, @RequestParam(name = "id") Long id){

        VideoGame videoGameToEdit = videoGameServices.findVideoGameById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("consoles", consoleServices.listAllConsoles());
        model.addAttribute("videogame",videoGameToEdit);

        return "/freemarker/editVideoGame";
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam(name = "idConsoles") List<Long> idConsoles, @RequestParam(name = "id") Long id, @RequestParam(name = "name") String name,@RequestParam(name = "developer") String developer, @RequestParam(name = "genre") String genre,@RequestParam(name = "gameModes") String gameModes,@RequestParam(name = "unitsSold") Double unitsSold, @RequestParam(name = "releasedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date releasedDate,@RequestParam(name = "rating") float rating, @RequestParam(name = "image") MultipartFile[] image){

        String imageName = fileUploadServices.almacenarAndDepurarImagen(image,uploadDirectory);

        VideoGame videoGameToEdit = videoGameServices.findVideoGameById(id);

        List<Console> consoleList = new ArrayList<>();

        for (Long consoles: idConsoles
             ) {

            Console consoleToAdd = consoleServices.findConsoleById(consoles);
            consoleList.add(consoleToAdd);
        }

        videoGameToEdit.setName(name);
        videoGameToEdit.setDeveloper(developer);
        videoGameToEdit.setGenre(genre);
        videoGameToEdit.setReleasedDate(releasedDate);
        videoGameToEdit.setGameModes(gameModes);
        videoGameToEdit.setUnitsSold(unitsSold);
        videoGameToEdit.setRating(rating);
        videoGameToEdit.setPlatformsList(consoleList);
        videoGameToEdit.setImage(imageName);

        videoGameServices.createVideoGame(videoGameToEdit);

        return "redirect:/videogames/";
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
    public String delete(@RequestParam(name = "id") long id ){

        VideoGame videoGameToDelete = videoGameServices.findVideoGameById(id);

        videoGameServices.deleteVideoGame(videoGameToDelete);

        return "redirect:/videogames/";
    }
}
