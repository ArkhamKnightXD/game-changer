package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Client;
import arkham.knight.gamestop.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServices clientServices;


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("clients", clientServices.listAllClients());

        return "/freemarker/clients";
    }


    @RequestMapping("/show")
    public String showPage(Model model, @RequestParam(name = "id") Long id){

        Client clientToShow = clientServices.findClientById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("client",clientToShow);

        return "/freemarker/showclient";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){

        Client clientToDelete = clientServices.findClientById(id);

        clientServices.deleteClient(clientToDelete);

        return "redirect:/clients/";
    }
}
