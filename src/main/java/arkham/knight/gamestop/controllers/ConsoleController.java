package arkham.knight.gamestop.controllers;

import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.services.ConsoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


@Controller
@RequestMapping("/consoles")
public class ConsoleController {

    @Autowired
    private ConsoleServices consoleServices;

    @RequestMapping("/")
    public String index(Model model){

        Date releasedDate = new Date();
        Date discontinueddDate = new Date();

        Console consoleTest = new Console("PlayStation 2","Sony","Home console","6th generation",releasedDate,discontinueddDate,15,150000000.0);
        consoleServices.createConsole(consoleTest);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("consoles",consoleServices.listAllConsoles());

        return "/freemarker/consoles";
    }

    @RequestMapping("/creation")
    public String creationPage(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/createConsole";
    }

    @RequestMapping("/create")
    public String create(@RequestParam(name = "name") String name, @RequestParam(name = "developer") String developer, @RequestParam(name = "consoleType") String consoleType, @RequestParam(name = "generation") String generation, @RequestParam(name = "unitsSold") Double unitsSold, @RequestParam(name = "releasedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date releasedDate, @RequestParam(name = "discontinuedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date discontinuedDate){

        Console consoleToCreate = new Console(name,developer,consoleType,generation,releasedDate,discontinuedDate,10,unitsSold);

        consoleServices.createConsole(consoleToCreate);


        return "redirect:/consoles/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/editConsole";
    }

    @RequestMapping("/edit")
    public String edit(){

        return "redirect:/consoles/";
    }


    @RequestMapping("/show")
    public String showPage(Model model){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/showConsole";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "idConsole") Long idConsole){

        Console consoleToDelete = consoleServices.findConsoleById(idConsole);

        consoleServices.deleteConsole(consoleToDelete);

        return "redirect:/consoles/";
    }



}
