package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.models.User;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.services.*;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private VideoGameService videoGameService;

    @Autowired
    private ConsoleService consoleService;

    @Autowired
    private UserService userService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ReportService reportService;


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/index";
    }


    @RequestMapping("/login")
    public String login(Model model){

        User adminUser = userService.findUserByUsername("admin");

        if (adminUser == null){

            userService.deleteAllRoles();

            securityService.createAdminUser();
        }

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/login";
    }


    @RequestMapping("/admin")
    public String admin(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("videogames", videoGameService.listAllVideoGames());
        model.addAttribute("sales", saleService.listAllSales());

        return "/freemarker/adminPage";
    }


    @RequestMapping("/report/{format}")
    public String salesReport(@PathVariable String format) throws FileNotFoundException, JRException {

         reportService.exportReport(format);

         return "redirect:/admin/";
    }


    @RequestMapping("/default")
    public String defaultCreatorConsoles(){

        consoleService.deleteAllConsoles();

        Calendar calendar = Calendar.getInstance();

        Calendar calendar2 = Calendar.getInstance();

        Calendar calendar3 = Calendar.getInstance();

        Calendar calendar4 = Calendar.getInstance();

        Calendar calendar5 = Calendar.getInstance();

        Calendar calendar6 = Calendar.getInstance();

        Calendar calendar7 = Calendar.getInstance();

        Calendar calendar8 = Calendar.getInstance();


        calendar.set(2000, Calendar.OCTOBER, 26);

        calendar2.set(2013, Calendar.JANUARY, 4);

        calendar3.set(1995, Calendar.SEPTEMBER, 9);

        calendar4.set(2006, Calendar.MARCH, 23);

        calendar5.set(2006, Calendar.NOVEMBER, 17);

        calendar6.set(2016, Calendar.OCTOBER, 15);

        calendar7.set(2013, Calendar.NOVEMBER, 15);

        calendar8.set(2020, Calendar.NOVEMBER, 30);


        Date ps2Date1 = calendar.getTime();

        Date ps2Date2 = calendar2.getTime();

        Date ps1Date1 = calendar3.getTime();

        Date ps1Date2 = calendar4.getTime();

        Date ps3Date1 = calendar5.getTime();

        Date ps3Date2 = calendar6.getTime();

        Date ps4Date1 = calendar7.getTime();

        Date ps4Date2 = calendar8.getTime();


        int lifeSpanPs1 = consoleService.calculateLifeSpanOfTheConsole(ps1Date1,ps1Date2);

        int lifeSpanPs2 = consoleService.calculateLifeSpanOfTheConsole(ps2Date1,ps2Date2);

        int lifeSpanPs3 = consoleService.calculateLifeSpanOfTheConsole(ps3Date1,ps3Date2);

        int lifeSpanPs4 = consoleService.calculateLifeSpanOfTheConsole(ps4Date1,ps4Date2);


        Console consolePredecessor = new Console("PlayStation 1","Sony","Home Console",5, ps1Date1,ps1Date2,lifeSpanPs1,2500,100000000,"ps1.jpg",5 );

        Console console = new Console("PlayStation 2","Sony","Home Console",6, ps2Date1,ps2Date2,lifeSpanPs2,4500,156000000,"ps2.jpg",3 );

        Console consoleSuccessor = new Console("PlayStation 3","Sony","Home Console",7, ps3Date1,ps3Date2,lifeSpanPs3,3000,83000000,"ps3.jpg" ,3);

        Console lastConsole = new Console("PlayStation 4","Sony","Home Console",8, ps4Date1,ps4Date2,lifeSpanPs4,3500.99f,100000000,"ps4.jpg" ,5);

        consoleService.createConsole(consolePredecessor);

        consoleService.createConsole(consoleSuccessor);

        consoleService.createConsole(lastConsole);

        console.setPredecessor(consolePredecessor);

        console.setSuccessor(consoleSuccessor);

        consoleService.createConsole(console);

        return "redirect:/admin/";
    }


    @RequestMapping("/default2")
    public String defaultCreatorVideoGames(){

        videoGameService.deleteAllVideoGames();

        Calendar calendar = Calendar.getInstance();

        Calendar calendar2 = Calendar.getInstance();

        Calendar calendar3 = Calendar.getInstance();

        Calendar calendar4 = Calendar.getInstance();

        Calendar calendar5 = Calendar.getInstance();

        Calendar calendar6 = Calendar.getInstance();

        Calendar calendar7 = Calendar.getInstance();

        Calendar calendar8 = Calendar.getInstance();

        Calendar calendar9 = Calendar.getInstance();


        calendar.set(2006, Calendar.JUNE, 26);

        calendar2.set(2007, Calendar.JUNE, 12);

        calendar3.set(2008, Calendar.MARCH, 25);

        calendar4.set(2009, Calendar.MARCH, 24);

        calendar5.set(2009, Calendar.NOVEMBER, 27);

        calendar6.set(2005, Calendar.MARCH, 22);

        calendar7.set(2007, Calendar.MARCH, 13);

        calendar8.set(2002, Calendar.MARCH, 28);

        calendar9.set(2006, Calendar.MARCH, 28);


        Date date = calendar.getTime();

        Date date2 = calendar2.getTime();

        Date date3 = calendar3.getTime();

        Date date4 = calendar4.getTime();

        Date date5 = calendar5.getTime();

        Date date6 = calendar6.getTime();

        Date date7 = calendar7.getTime();

        Date date8 = calendar8.getTime();

        Date date9 = calendar9.getTime();


        List<Console> consoleList = new ArrayList<>();

        List<Console> consoleList1 = new ArrayList<>();

        Console ps2 = consoleService.findConsoleByName("PlayStation 2");

        Console ps3 = consoleService.findConsoleByName("PlayStation 3");

        consoleList.add(ps2);

        consoleList1.add(ps2);

        consoleList1.add(ps3);

        VideoGame videoGame1 = new VideoGame("Naruto Ultimate Ninja","Bandai Namco",date,"2D Fighting", 1200000,"Single-player, multiplayer",8.5f,1500,"naruto.jpg",5,consoleList);

        VideoGame videoGame2 = new VideoGame("Naruto Ultimate Ninja 2","Bandai Namco",date2,"2D Fighting", 1400000,"Single-player, multiplayer",9.5f,1300,"naruto2.jpg",5,consoleList);

        VideoGame videoGame3 = new VideoGame("Naruto Ultimate Ninja 3","Bandai Namco",date3,"2D Fighting", 1500000,"Single-player, multiplayer",7,1250,"naruto3.jpg",5,consoleList);

        VideoGame videoGame4 = new VideoGame("Naruto Ultimate Ninja 4","Bandai Namco",date4,"2D Fighting", 2000000,"Single-player, multiplayer",9,1800,"naruto4.jpg",3,consoleList);

        VideoGame videoGame5 = new VideoGame("Naruto Ultimate Ninja 5","Bandai Namco",date5,"2D Fighting", 1800000,"Single-player, multiplayer",9.6f,2350,"naruto5.jpg",5,consoleList);

        VideoGame videoGame6 = new VideoGame("God of War II","Santa Monica Studio",date6,"Hack And Slash", 4600000,"Single-player",9.8f,2100,"god of war 2.jpg",4,consoleList1);

        VideoGame videoGame7 = new VideoGame("God of War","Santa Monica Studio",date7,"Hack And Slash", 5000000,"Single-player",9.9f,2000,"god of war.jpg",4,consoleList1);

        VideoGame videoGame8 = new VideoGame("Kingdom Hearts","Square Enix",date8,"JRPG", 4800000,"Single-player",9.7f,2200,"kh.jpg",5,consoleList1);

        VideoGame videoGame9 = new VideoGame("Kingdom Hearts II","Square Enix",date9,"JRPG", 4000000,"Single-player",9.5f,1550,"kh 2.jpg",5,consoleList1);

        videoGameService.createVideoGame(videoGame1);
        videoGameService.createVideoGame(videoGame2);
        videoGameService.createVideoGame(videoGame3);
        videoGameService.createVideoGame(videoGame4);
        videoGameService.createVideoGame(videoGame5);
        videoGameService.createVideoGame(videoGame6);
        videoGameService.createVideoGame(videoGame7);
        videoGameService.createVideoGame(videoGame8);
        videoGameService.createVideoGame(videoGame9);

        return "redirect:/admin/";
    }
}
