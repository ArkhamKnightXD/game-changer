package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.models.Rol;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.services.ConsoleServices;
import arkham.knight.gamestop.services.UserServices;
import arkham.knight.gamestop.services.VideoGameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private VideoGameServices videoGameServices;

    @Autowired
    private ConsoleServices consoleServices;

    @Autowired
    private UserServices userServices;


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/index";
    }


    @RequestMapping("/admin")
    public String admin(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("videogames", videoGameServices.listAllVideoGames());

        return "/freemarker/adminPage";
    }


    @RequestMapping("/default")
    public String defaultCreatorConsoles(){

        userServices.deleteAllRoles();

        Rol rol = new Rol("Admin");

        userServices.createRole(rol);

        consoleServices.deleteAllConsoles();

        Date date1 = new Date();
        Date date2 = new Date();

        Console consolePredecessor = new Console("PlayStation 1","Sony","Home Console",5, date1,date2,10,45.4,"ps1.jpg" );

        Console console = new Console("PlayStation 2","Sony","Home Console",6, date1,date2,10,45.4,"ps2.jpg" );

        Console consoleSuccessor = new Console("PlayStation 3","Sony","Home Console",7, date1,date2,10,45.4,"ps3.jpg" );

        Console lastConsole = new Console("PlayStation 4","Sony","Home Console",8, date1,date2,10,45.4,"ps4.jpg" );


        consoleServices.createConsole(consolePredecessor);

        consoleServices.createConsole(consoleSuccessor);

        consoleServices.createConsole(lastConsole);

        console.setPredecessor(consolePredecessor);
        console.setSuccessor(consoleSuccessor);

        consoleServices.createConsole(console);

        return "redirect:/admin/";
    }


    @RequestMapping("/default2")
    public String defaultCreatorVideoGames(){

        videoGameServices.deleteAllVideoGames();

        Date date = new Date();

        List<Console> consoleList = new ArrayList<>();

        List<Console> consoleList1 = new ArrayList<>();

        Console ps2 = consoleServices.findConsoleByName("PlayStation 2");

        Console ps3 = consoleServices.findConsoleByName("PlayStation 3");

        consoleList.add(ps2);

        consoleList1.add(ps2);
        consoleList1.add(ps3);


        VideoGame videoGame1 = new VideoGame("Naruto Ultimate Ninja","Bandai Namco",date,"2D Fighting", 4.5,"Single-player, multiplayer",4,"naruto.jpg",consoleList);

        VideoGame videoGame2 = new VideoGame("Naruto Ultimate Ninja 2","Bandai Namco",date,"2D Fighting", 4.5,"Single-player, multiplayer",4,"naruto2.jpg",consoleList);

        VideoGame videoGame3 = new VideoGame("Naruto Ultimate Ninja 3","Bandai Namco",date,"2D Fighting", 4.5,"Single-player, multiplayer",4,"naruto3.jpg",consoleList);

        VideoGame videoGame4 = new VideoGame("Naruto Ultimate Ninja 4","Bandai Namco",date,"2D Fighting", 4.5,"Single-player, multiplayer",4,"naruto4.jpg",consoleList);

        VideoGame videoGame5 = new VideoGame("Naruto Ultimate Ninja 5","Bandai Namco",date,"2D Fighting", 4.5,"Single-player, multiplayer",4,"naruto5.jpg",consoleList);

        VideoGame videoGame6 = new VideoGame("God of War II","Santa Monica Studio",date,"Hack And Slash", 4.5,"Single-player",4,"god of war 2.jpg",consoleList1);

        VideoGame videoGame7 = new VideoGame("God of War","Santa Monica Studio",date,"Hack And Slash", 4.5,"Single-player",4,"god of war.jpg",consoleList1);

        VideoGame videoGame8 = new VideoGame("Kingdom Hearts","Square Enix",date,"JRPG", 4.5,"Single-player",4,"kh.jpg",consoleList1);

        VideoGame videoGame9 = new VideoGame("Kingdom Hearts II","Square Enix",date,"JRPG", 4.5,"Single-player",4,"kh 2.jpg",consoleList1);


        videoGameServices.createVideoGame(videoGame1);
        videoGameServices.createVideoGame(videoGame2);
        videoGameServices.createVideoGame(videoGame3);
        videoGameServices.createVideoGame(videoGame4);
        videoGameServices.createVideoGame(videoGame5);
        videoGameServices.createVideoGame(videoGame6);
        videoGameServices.createVideoGame(videoGame7);
        videoGameServices.createVideoGame(videoGame8);
        videoGameServices.createVideoGame(videoGame9);

        return "redirect:/admin/";
    }
}
