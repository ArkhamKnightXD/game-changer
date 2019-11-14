package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Sale;
import arkham.knight.gamestop.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SaleServices {

    @Autowired
    private SaleRepository saleRepository;


    public void createSale(Sale sale){

        saleRepository.save(sale);
    }


    public List<Sale> listAllSales(){

        return saleRepository.findAll();
    }


    public Sale findSaleById(long id){

        return saleRepository.findSaleById(id);
    }


    public void deleteSale(Sale sale){

        saleRepository.delete(sale);

    }


    public void deleteAllSales(){

        saleRepository.deleteAll();
    }
}
