package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Client;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.models.Sale;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.services.ClientServices;
import arkham.knight.gamestop.services.ConsoleServices;
import arkham.knight.gamestop.services.SaleServices;
import arkham.knight.gamestop.services.VideoGameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleServices saleServices;

    @Autowired
    private ClientServices clientServices;

    @Autowired
    private ConsoleServices consoleServices;

    @Autowired
    private VideoGameServices videoGameServices;


    private float getTotalOfTheSalesAndCalculateTheStock(List<Long> idVideoGames, List<Long> idConsoles, String identify){

        int consoleStock =0;

        int videoGameStock = 0;

        float total = 0;


        for (Long videoGames: idVideoGames
        ) {

            VideoGame videoGameToBuy = videoGameServices.findVideoGameById(videoGames);

            videoGameStock = videoGameToBuy.getStock();

            if (identify.equalsIgnoreCase("sale")){

                videoGameStock--;

                videoGameToBuy.setStock(videoGameStock);

                videoGameServices.createVideoGame(videoGameToBuy);

                total+= videoGameToBuy.getSellPrice();
            }

            if (identify.equalsIgnoreCase("devolution")){

                total = videoGameToBuy.getSellPrice();

                videoGameStock++;

                videoGameToBuy.setStock(videoGameStock);

                videoGameServices.createVideoGame(videoGameToBuy);

                total-= videoGameToBuy.getSellPrice();
            }

        }


        for (Long consoles: idConsoles
        ) {

            Console consolesToBuy = consoleServices.findConsoleById(consoles);

            consoleStock = consolesToBuy.getStock();

            if (identify.equalsIgnoreCase("sale")){

                consoleStock--;

                consolesToBuy.setStock(consoleStock);

                consoleServices.createConsole(consolesToBuy);

                total+= consolesToBuy.getSellPrice();
            }

            if (identify.equalsIgnoreCase("devolution")){

                total = consolesToBuy.getSellPrice();

                consoleStock++;

                consolesToBuy.setStock(consoleStock);

                consoleServices.createConsole(consolesToBuy);

                total-= consolesToBuy.getSellPrice();
            }
        }

        return total;
    }


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("sales", saleServices.listAllSales());

        return "/freemarker/sales";
    }


    @RequestMapping("/creation")
    public String creationPage(Model model ){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("clients", clientServices.listAllClients());
        model.addAttribute("consoles", consoleServices.listAllConsoles());
        model.addAttribute("videogames", videoGameServices.listAllVideoGames());

        return "/freemarker/createSale";
    }


    @RequestMapping("/create")
    public String create(@RequestParam(name = "soldDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date soldDate, @RequestParam(required = false, name = "idConsoles") List<Long> idConsoles, @RequestParam(required = false, name = "idVideoGames") List<Long> idVideoGames, @RequestParam(name = "idClient") Long idClient){

        float total =0;

        String identify = "sale";

        total = getTotalOfTheSalesAndCalculateTheStock(idVideoGames,idConsoles,identify);

        Client buyer = clientServices.findClientById(idClient);

        Sale saleToCreate = new Sale(soldDate,total,consoleServices.findAllConsolesById(idConsoles),videoGameServices.findAllVideoGamesById(idVideoGames),buyer);

        saleServices.createSale(saleToCreate);

        return "redirect:/sales/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model, @RequestParam(name = "id") Long id){

        Sale saleToEdit = saleServices.findSaleById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("sale", saleToEdit);
        model.addAttribute("client", saleToEdit.getBuyer());
        model.addAttribute("consoles", saleToEdit.getConsoleListToSell());
        model.addAttribute("videogames", saleToEdit.getVideoGameListToSell());

        return "/freemarker/editSale";
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, @RequestParam(name = "soldDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date soldDate, @RequestParam(required = false, name = "idConsoles") List<Long> idConsoles, @RequestParam(required = false, name = "idVideoGames") List<Long> idVideoGames, @RequestParam(name = "idClient") Long idClient){

        String identify = "devolution";

        float total =0;

        // el programa me falla en esta funcion cuando cuando mando idVideoGames null o idConsoles null ya que son listas
        total = getTotalOfTheSalesAndCalculateTheStock(idVideoGames,idConsoles,identify);

        Client buyer = clientServices.findClientById(idClient);

        Sale saleToEdit = saleServices.findSaleById(id);

        saleToEdit.setSoldDate(soldDate);
        saleToEdit.setTotal(total);
        saleToEdit.setConsoleListToSell(consoleServices.findAllConsolesById(idConsoles));
        saleToEdit.setVideoGameListToSell(videoGameServices.findAllVideoGamesById(idVideoGames));
        saleToEdit.setBuyer(buyer);

        saleServices.createSale(saleToEdit);

        return "redirect:/sales/";
    }


    @RequestMapping("/show")
    public String showPage(Model model, @RequestParam(name = "id") Long id){

        Sale saleToShow = saleServices.findSaleById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("sale", saleToShow);

        return "/freemarker/showSale";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){

        Sale saleToDelete = saleServices.findSaleById(id);

        saleServices.deleteSale(saleToDelete);

        return "redirect:/sales/";
    }
}
