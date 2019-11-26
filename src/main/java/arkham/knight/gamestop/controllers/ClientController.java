package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Client;
import arkham.knight.gamestop.services.ClientServices;
import arkham.knight.gamestop.services.FileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServices clientServices;

    @Autowired
    private FileUploadServices fileUploadServices;

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/bootstrap-4.3.1/assets/img/store/clients";


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("clients", clientServices.listAllClients());

        return "/freemarker/clients";
    }


    @RequestMapping("/creation")
    public String creationPage(Model model ){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/createClient";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "name") String name,@RequestParam(name = "lastName") String lastName,@RequestParam(name = "address") String address,@RequestParam(name = "phone") String phone,@RequestParam(name = "email") String email,@RequestParam(name = "photo") MultipartFile[] photo ){

        String photoName = fileUploadServices.storeAndCleanImage(photo,uploadDirectory);

        Client clientToCreate = new Client(name,lastName,address,phone,email,photoName);

        clientServices.createClient(clientToCreate);

        return "redirect:/clients/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model,@RequestParam(name = "id") Long id){

        Client clientToEdit = clientServices.findClientById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("client", clientToEdit);

        return "/freemarker/editClient";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam(name = "id")Long id, @RequestParam(name = "name") String name,@RequestParam(name = "lastName") String lastName,@RequestParam(name = "address") String address,@RequestParam(name = "phone") String phone,@RequestParam(name = "email") String email,@RequestParam(required = false, name = "photo" ) MultipartFile[] photo ){

        String photoName = fileUploadServices.storeAndCleanImage(photo,uploadDirectory);

        Client clientToEdit = clientServices.findClientById(id);

        clientToEdit.setName(name);
        clientToEdit.setLastName(lastName);
        clientToEdit.setAddress(address);
        clientToEdit.setPhone(phone);
        clientToEdit.setEmail(email);

        if (photoName.endsWith("jpg")){

            clientToEdit.setPhoto(photoName);
        }

        clientServices.createClient(clientToEdit);

        return "redirect:/clients/";
    }


    @RequestMapping("/show")
    public String showPage(Model model, @RequestParam(name = "id") Long id){

        Client clientToShow = clientServices.findClientById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("client",clientToShow);

        return "/freemarker/showClient";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){

        clientServices.deleteClient(id);

        return "redirect:/clients/";
    }
}
