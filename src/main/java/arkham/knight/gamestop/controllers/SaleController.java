package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Client;
import arkham.knight.gamestop.models.Sale;
import arkham.knight.gamestop.services.ClientService;
import arkham.knight.gamestop.services.ConsoleService;
import arkham.knight.gamestop.services.SaleService;
import arkham.knight.gamestop.services.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ConsoleService consoleService;

    @Autowired
    private VideoGameService videoGameService;


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("sales", saleService.listAllSales());

        return "/freemarker/sales";
    }


    @RequestMapping("/creation")
    public String creationPage(Model model ){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("clients", clientService.listAllClients());
        model.addAttribute("consoles", consoleService.listAllConsoles());
        model.addAttribute("videogames", videoGameService.listAllVideoGames());

        return "/freemarker/createSale";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "soldDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date soldDate, @RequestParam(required = false, name = "idConsoles") List<Long> idConsoles, @RequestParam(required = false, name = "idVideoGames") List<Long> idVideoGames, @RequestParam(name = "idClient") Long idClient){

        float total;

        total = saleService.getTotalOfTheSalesAndCalculateTheStock(idVideoGames,idConsoles);

        Client buyer = clientService.findClientById(idClient);

        Sale saleToCreate = new Sale(soldDate,total, consoleService.findAllConsolesById(idConsoles), videoGameService.findAllVideoGamesById(idVideoGames),buyer);

        saleService.createSale(saleToCreate);

        return "redirect:/sales/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model, @RequestParam(name = "id") Long id){

        Sale saleToEdit = saleService.findSaleById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("sale", saleToEdit);
        model.addAttribute("client", saleToEdit.getBuyer());
        model.addAttribute("consoles", saleToEdit.getConsoleListToSell());
        model.addAttribute("videogames", saleToEdit.getVideoGameListToSell());

        return "/freemarker/editSale";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam(name = "id") Long id, @RequestParam(name = "soldDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date soldDate, @RequestParam(required = false, name = "idConsoles") List<Long> idConsoles, @RequestParam(required = false, name = "idVideoGames") List<Long> idVideoGames, @RequestParam(name = "idClient") Long idClient){

        Client buyer = clientService.findClientById(idClient);

        Sale saleToEdit = saleService.findSaleById(id);

        //aun con fallas en la devolucion, voy a implementar otro metodo de devolucion ya que este no es muy eficiente

        saleToEdit.setSoldDate(soldDate);
      //  saleToEdit.setConsoleListToSell(saleServices.removeConsoleAndCalculateTotalFromTheSale(saleToEdit.getConsoleListToSell(),idConsoles,saleToEdit));
       // saleToEdit.setVideoGameListToSell(saleServices.removeVideoGameAndCalculateTotalFromTheSale(saleToEdit.getVideoGameListToSell(),idVideoGames,saleToEdit));
        saleToEdit.setBuyer(buyer);

        saleService.createSale(saleToEdit);

        return "redirect:/sales/";
    }


    @RequestMapping("/show")
    public String showPage(Model model, @RequestParam(name = "id") Long id){

        Sale saleToShow = saleService.findSaleById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("sale", saleToShow);

        return "/freemarker/showSale";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){

        saleService.deleteSale(id);

        return "redirect:/sales/";
    }
}
