package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.models.User;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.services.ConsoleServices;
import arkham.knight.gamestop.services.SecurityServices;
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

    @Autowired
    private SecurityServices securityServices;


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/index";
    }


    @RequestMapping("/login")
    public String login(Model model){

        User adminUser = userServices.findUserByUsername("admin");

        if (adminUser == null){

            securityServices.createAdminUser();
        }

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/login";
    }


    @RequestMapping("/admin")
    public String admin(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("videogames", videoGameServices.listAllVideoGames());

        return "/freemarker/adminPage";
    }


    @RequestMapping("/default")
    public String defaultCreatorConsoles(){

        consoleServices.deleteAllConsoles();

        Date date1 = new Date();

        Date date2 = new Date();

        Console consolePredecessor = new Console("PlayStation 1","Sony","Home Console",5, date1,date2,10,2400,45.4,"ps1.jpg",5 );

        Console console = new Console("PlayStation 2","Sony","Home Console",6, date1,date2,10,4500,45.4,"ps2.jpg",3 );

        Console consoleSuccessor = new Console("PlayStation 3","Sony","Home Console",7, date1,date2,10,3700,45.4,"ps3.jpg" ,3);

        Console lastConsole = new Console("PlayStation 4","Sony","Home Console",8, date1,date2,10,3500,45.4,"ps4.jpg" ,5);

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

        VideoGame videoGame1 = new VideoGame("Naruto Ultimate Ninja","Bandai Namco",date,"2D Fighting", 4.5,"Single-player, multiplayer",4,1500,"naruto.jpg",5,consoleList);

        VideoGame videoGame2 = new VideoGame("Naruto Ultimate Ninja 2","Bandai Namco",date,"2D Fighting", 4.5,"Single-player, multiplayer",4,1300,"naruto2.jpg",5,consoleList);

        VideoGame videoGame3 = new VideoGame("Naruto Ultimate Ninja 3","Bandai Namco",date,"2D Fighting", 4.5,"Single-player, multiplayer",4,1250,"naruto3.jpg",5,consoleList);

        VideoGame videoGame4 = new VideoGame("Naruto Ultimate Ninja 4","Bandai Namco",date,"2D Fighting", 4.5,"Single-player, multiplayer",4,1800,"naruto4.jpg",3,consoleList);

        VideoGame videoGame5 = new VideoGame("Naruto Ultimate Ninja 5","Bandai Namco",date,"2D Fighting", 4.5,"Single-player, multiplayer",4,2350,"naruto5.jpg",5,consoleList);

        VideoGame videoGame6 = new VideoGame("God of War II","Santa Monica Studio",date,"Hack And Slash", 4.5,"Single-player",4,2120,"god of war 2.jpg",4,consoleList1);

        VideoGame videoGame7 = new VideoGame("God of War","Santa Monica Studio",date,"Hack And Slash", 4.5,"Single-player",4,1870,"god of war.jpg",4,consoleList1);

        VideoGame videoGame8 = new VideoGame("Kingdom Hearts","Square Enix",date,"JRPG", 4.5,"Single-player",4,2444,"kh.jpg",5,consoleList1);

        VideoGame videoGame9 = new VideoGame("Kingdom Hearts II","Square Enix",date,"JRPG", 4.5,"Single-player",4,1570,"kh 2.jpg",5,consoleList1);

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
