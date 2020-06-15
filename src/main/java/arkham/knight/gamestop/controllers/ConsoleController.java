package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.services.ConsoleService;
import arkham.knight.gamestop.services.FileUploadService;
import arkham.knight.gamestop.services.VideoGameService;
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
@RequestMapping("/consoles")
public class ConsoleController {

    @Autowired
    private ConsoleService consoleService;

    @Autowired
    private VideoGameService videoGameService;

    @Autowired
    private FileUploadService fileUploadService;

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/bootstrap-4.3.1/assets/img";


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("consoles", consoleService.listAllConsoles());

        return "/freemarker/homeConsoleInfo";
    }


    @RequestMapping("/admin")
    public String adminConsole(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("consoles", consoleService.listAllConsoles());

        return "/freemarker/consoles";
    }


    @RequestMapping("/creation")
    public String creationPage(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("predecessorConsoles", consoleService.listAllConsoles());
        model.addAttribute("successorConsoles", consoleService.listAllConsoles());

        return "/freemarker/createConsole";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "name") String name, @RequestParam(name = "developer") String developer, @RequestParam(name = "consoleType") String consoleType, @RequestParam(name = "generation") int generation, @RequestParam(name = "unitsSold") int unitsSold, @RequestParam(name = "releasedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date releasedDate, @RequestParam(name = "discontinuedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date discontinuedDate, @RequestParam(name = "image") MultipartFile[] image,@RequestParam(required = false,name = "idPredecessorConsole") Long idPredecessorConsole, @RequestParam(required = false, name = "idSuccessorConsole")  Long idSuccessorConsole, @RequestParam(name = "sellPrice") float sellPrice, @RequestParam(name = "stock") int stock){

        int lifeSpan = consoleService.calculateLifeSpanOfTheConsole(releasedDate, discontinuedDate);

        String imageName = fileUploadService.storeAndCleanImage(image,uploadDirectory);

        Console consoleToCreate = new Console(name,developer,consoleType,generation,releasedDate,discontinuedDate,lifeSpan,sellPrice,unitsSold,imageName,stock, videoGameService.findAllVideoGamesByPlatformName(name), consoleService.findConsoleById(idPredecessorConsole), consoleService.findConsoleById(idSuccessorConsole));

        consoleService.createConsole(consoleToCreate);

        return "redirect:/consoles/admin";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model, @RequestParam(name = "id") Long id){

        Console consoleToEdit = consoleService.findConsoleById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("console",consoleToEdit);
        model.addAttribute("predecessorConsoles", consoleService.listConsolesByGeneration(consoleToEdit.getGeneration()-1));
        model.addAttribute("successorConsoles", consoleService.listConsolesByGeneration(consoleToEdit.getGeneration()+1));

        return "/freemarker/editConsole";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam(name = "id") Long id ,@RequestParam(name = "name") String name, @RequestParam(name = "developer") String developer, @RequestParam(name = "consoleType") String consoleType, @RequestParam(name = "generation") int generation, @RequestParam(defaultValue = "empty", required = false, name = "unitsSold") String unitsSold, @RequestParam(defaultValue = "empty", required = false, name = "releasedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String releasedDate, @RequestParam(defaultValue = "empty", required = false, name = "discontinuedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String discontinuedDate, @RequestParam(required = false,name = "image") MultipartFile[] image, @RequestParam(required = false, name = "idPredecessorConsole") Long idPredecessorConsole, @RequestParam(required = false, name = "idSuccessorConsole")  Long idSuccessorConsole, @RequestParam(defaultValue = "empty", required = false, name = "sellPrice") String sellPrice, @RequestParam(name = "stock") int stock){

        Date releasedDate1 = consoleService.convertFromStringToDateAndSetTheDate(releasedDate,"ReleasedDate",id);

        Date discontinuedDate1 = consoleService.convertFromStringToDateAndSetTheDate(discontinuedDate,"DiscontinuedDate",id);

        int lifeSpan = consoleService.calculateLifeSpanOfTheConsole(releasedDate1,discontinuedDate1);

        Console consoleToEdit = consoleService.findConsoleById(id);

        String imageName = fileUploadService.storeAndCleanImage(image,uploadDirectory);

        String identifier = "Console";


        consoleToEdit.setSellPrice(consoleService.convertFromStringToFloatAndSetThePrice(sellPrice,identifier,id));
        consoleToEdit.setUnitsSold(consoleService.convertFromStringToIntAndSetTheUnitsSold(unitsSold,identifier, id));
        consoleToEdit.setName(name);
        consoleToEdit.setDeveloper(developer);
        consoleToEdit.setConsoleType(consoleType);
        consoleToEdit.setGeneration(generation);
        consoleToEdit.setReleasedDate(releasedDate1);
        consoleToEdit.setDiscontinuedDate(discontinuedDate1);
        consoleToEdit.setLifespan(lifeSpan);
        consoleToEdit.setStock(stock);
        consoleToEdit.setPredecessor(consoleService.findConsoleById(idPredecessorConsole));
        consoleToEdit.setSuccessor(consoleService.findConsoleById(idSuccessorConsole));

        if (imageName.endsWith("jpg")){

            consoleToEdit.setImage(imageName);
        }

        consoleService.createConsole(consoleToEdit);

        return "redirect:/consoles/admin";
    }


    @RequestMapping("/show")
    public String showPage(Model model, @RequestParam(name = "id") Long id){

        Console consoleToShow = consoleService.findConsoleById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("console",consoleToShow);

        return "/freemarker/showConsole";
    }


    @RequestMapping("/showHomeConsole")
    public String showHomeConsoleDescription(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("consoles", consoleService.listConsolesByType("Home console"));

        return "/freemarker/homeConsoleInfo";
    }


    @RequestMapping("/showHandheldConsole")
    public String showHandheldConsoleDescription(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("consoles", consoleService.listConsolesByType("Handheld console"));

        return "/freemarker/handheldConsoleInfo";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){

        consoleService.deleteConsole(id);

        return "redirect:/consoles/admin";
    }
}
