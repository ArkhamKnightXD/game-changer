package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Console;
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
import java.util.Date;

@Controller
@RequestMapping("/consoles")
public class ConsoleController {

    @Autowired
    private ConsoleServices consoleServices;

    @Autowired
    private VideoGameServices videoGameServices;

    @Autowired
    private FileUploadServices fileUploadServices;

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/bootstrap-4.3.1/assets/img";


    private Console getPredecessorConsoleWithIdConsole(Long idPredecessorConsole){

        if (idPredecessorConsole !=null){

            Console predecessorConsole = consoleServices.findConsoleById(idPredecessorConsole);

            return predecessorConsole;

        }

        else
            return null;
    }


    private Console getSuccessorConsoleWithIdConsole(Long idSuccessorConsole){

        if (idSuccessorConsole != null){

            Console successorConsole = consoleServices.findConsoleById(idSuccessorConsole);

            return successorConsole;
        }

        else
            return null;
    }


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("consoles",consoleServices.listAllConsoles());

        return "/freemarker/homeConsoleInfo";
    }


    @RequestMapping("/admin")
    public String adminConsole(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("consoles",consoleServices.listAllConsoles());

        return "/freemarker/consoles";
    }


    @RequestMapping("/creation")
    public String creationPage(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("predecessorConsoles",consoleServices.listAllConsoles());
        model.addAttribute("successorConsoles", consoleServices.listAllConsoles());

        return "/freemarker/createConsole";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "name") String name, @RequestParam(name = "developer") String developer, @RequestParam(name = "consoleType") String consoleType, @RequestParam(name = "generation") int generation, @RequestParam(name = "unitsSold") Double unitsSold, @RequestParam(name = "releasedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date releasedDate, @RequestParam(name = "discontinuedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date discontinuedDate, @RequestParam(name = "image") MultipartFile[] image,@RequestParam(required = false,name = "idPredecessorConsole") Long idPredecessorConsole, @RequestParam(required = false, name = "idSuccessorConsole")  Long idSuccessorConsole, @RequestParam(name = "sellPrice") float sellPrice){

        String imageName = fileUploadServices.almacenarAndDepurarImagen(image,uploadDirectory);

        Console consoleToCreate = new Console(name,developer,consoleType,generation,releasedDate,discontinuedDate,11,sellPrice,unitsSold,imageName,videoGameServices.findAllVideoGamesByPlatformName(name),getPredecessorConsoleWithIdConsole(idPredecessorConsole),getSuccessorConsoleWithIdConsole(idSuccessorConsole));

        consoleServices.createConsole(consoleToCreate);

        return "redirect:/consoles/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model, @RequestParam(name = "id") Long id){

        Console consoleToEdit = consoleServices.findConsoleById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("console",consoleToEdit);
        model.addAttribute("predecessorConsoles", consoleServices.listConsolesByGeneration(consoleToEdit.getGeneration()-1));
        model.addAttribute("successorConsoles", consoleServices.listConsolesByGeneration(consoleToEdit.getGeneration()+1));

        return "/freemarker/editConsole";
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id ,@RequestParam(name = "name") String name, @RequestParam(name = "developer") String developer, @RequestParam(name = "consoleType") String consoleType, @RequestParam(name = "generation") int generation, @RequestParam(name = "unitsSold") Double unitsSold, @RequestParam(name = "releasedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date releasedDate, @RequestParam(name = "discontinuedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date discontinuedDate, @RequestParam(name = "image") MultipartFile[] image, @RequestParam(required = false,name = "idPredecessorConsole") Long idPredecessorConsole, @RequestParam(required = false, name = "idSuccessorConsole")  Long idSuccessorConsole, @RequestParam(name = "sellPrice") float sellPrice){

        Console consoleToEdit = consoleServices.findConsoleById(id);

        String imageName = fileUploadServices.almacenarAndDepurarImagen(image,uploadDirectory);

        consoleToEdit.setName(name);
        consoleToEdit.setDeveloper(developer);
        consoleToEdit.setConsoleType(consoleType);
        consoleToEdit.setGeneration(generation);
        consoleToEdit.setUnitsSold(unitsSold);
        consoleToEdit.setReleasedDate(releasedDate);
        consoleToEdit.setDiscontinuedDate(discontinuedDate);
        consoleToEdit.setSellPrice(sellPrice);
        consoleToEdit.setImage(imageName);
        consoleToEdit.setPredecessor(getPredecessorConsoleWithIdConsole(idPredecessorConsole));
        consoleToEdit.setSuccessor(getSuccessorConsoleWithIdConsole(idSuccessorConsole));

        consoleServices.createConsole(consoleToEdit);

        return "redirect:/consoles/";
    }


    @RequestMapping("/show")
    public String showPage(Model model, @RequestParam(name = "id") Long id){

        Console consoleToShow = consoleServices.findConsoleById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("console",consoleToShow);

        return "/freemarker/showConsole";
    }


    @RequestMapping("/showHomeConsole")
    public String showHomeConsoleDescription(Model model){

        model.addAttribute("title","Welcome to the game store");

        model.addAttribute("consoles",consoleServices.listConsolesByType("Home console"));

        return "/freemarker/homeConsoleInfo";
    }


    @RequestMapping("/showHandheldConsole")
    public String showHandheldConsoleDescription(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("consoles",consoleServices.listConsolesByType("Handheld console"));

        return "/freemarker/handheldConsoleInfo";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){

        Console consoleToDelete = consoleServices.findConsoleById(id);

        consoleServices.deleteConsole(consoleToDelete);

        return "redirect:/consoles/";
    }
}
