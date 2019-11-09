package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Venta;
import arkham.knight.gamestop.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaServices {

    @Autowired
    private VentaRepository ventaRepository;


    public void createVenta(Venta venta){

        ventaRepository.save(venta);
    }


    public List<Venta> listAllVentas(){

        return ventaRepository.findAll();
    }


    public Venta findVentaById(long id){

        return ventaRepository.findVentaById(id);
    }


    public void deleteVenta(Venta venta){

        ventaRepository.delete(venta);

    }


    public void deleteAllVentas(){

        ventaRepository.deleteAll();
    }
}
