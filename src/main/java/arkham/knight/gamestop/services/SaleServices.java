package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.models.Sale;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.repositories.ConsoleRepository;
import arkham.knight.gamestop.repositories.SaleRepository;
import arkham.knight.gamestop.repositories.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SaleServices {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private VideoGameRepository videoGameRepository;

    @Autowired
    private ConsoleRepository consoleRepository;


    public void createSale(Sale sale){

        saleRepository.save(sale);
    }


    public List<Sale> listAllSales(){

        return saleRepository.findAll();
    }


    public Sale findSaleById(long id){

        return saleRepository.findSaleById(id);
    }


    public void deleteSale(Long id){

        saleRepository.deleteById(id);
    }


    public void deleteAllSales(){

        saleRepository.deleteAll();
    }


    public float getTotalOfTheSalesAndCalculateTheStock(List<Long> idVideoGames, List<Long> idConsoles){

        float total = 0;

        for (Long videoGamesId: idVideoGames
        ) {

                VideoGame videoGameToBuy = videoGameRepository.findVideoGameById(videoGamesId);

                videoGameToBuy.setStock(videoGameToBuy.getStock()-1);

                videoGameRepository.save(videoGameToBuy);

                total+= videoGameToBuy.getSellPrice();
        }


        for (Long consolesId: idConsoles
        ) {

                Console consolesToBuy = consoleRepository.findConsoleById(consolesId);

                consolesToBuy.setStock(consolesToBuy.getStock()-1);

                consoleRepository.save(consolesToBuy);

                total+= consolesToBuy.getSellPrice();
        }

        return total;
    }
}
