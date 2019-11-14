package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Sale;
import arkham.knight.gamestop.services.SaleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleServices saleServices;


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("sales", saleServices.listAllSales());

        return "/freemarker/sales";
    }


    @RequestMapping("/creation")
    public String creationPage(Model model ){

        model.addAttribute("title","Welcome to the game store");

        return "/freemarker/createSale";
    }


    @RequestMapping("/create")
    public String create(){

        Sale saleToCreate = new Sale();


        return "redirect:/sales/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model, @RequestParam(name = "id") Long id){

        Sale saleToEdit = saleServices.findSaleById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("sale", saleToEdit);

        return "/freemarker/editSale";
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id){

        Sale saleToEdit = saleServices.findSaleById(id);


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
