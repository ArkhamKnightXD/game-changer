package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.Venta;
import arkham.knight.gamestop.services.VentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaServices ventaServices;


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("ventas", ventaServices.listAllVentas());

        return "/freemarker/ventas";
    }


    @RequestMapping("/show")
    public String showPage(Model model, @RequestParam(name = "id") Long id){

        Venta ventaToShow = ventaServices.findVentaById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("venta",ventaToShow);

        return "/freemarker/showVenta";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){

        Venta ventaToDelete = ventaServices.findVentaById(id);

        ventaServices.deleteVenta(ventaToDelete);

        return "redirect:/ventas/";
    }
}
