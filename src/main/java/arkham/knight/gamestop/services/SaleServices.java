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


    public float getTotalOfTheSalesAndCalculateTheStock(List<Long> idVideoGames, List<Long> idConsoles, String identify, Sale sale){

        // falla en la parte de devolution de esta funcion tanto para consola como para videojuego, ver como solucionar esto

        int consoleStock =0;

        int videoGameStock = 0;

        float total = 0;


        for (Long videoGames: idVideoGames
        ) {

            VideoGame videoGameToBuy = videoGameRepository.findVideoGameById(videoGames);

            videoGameStock = videoGameToBuy.getStock();

            if (identify.equalsIgnoreCase("sale")){

                videoGameStock--;

                videoGameToBuy.setStock(videoGameStock);

                videoGameRepository.save(videoGameToBuy);

                total+= videoGameToBuy.getSellPrice();
            }

            if (identify.equalsIgnoreCase("devolution")){

                total = sale.getTotal();

                videoGameStock++;

                videoGameToBuy.setStock(videoGameStock);

                videoGameRepository.save(videoGameToBuy);

                total-= videoGameToBuy.getSellPrice();
            }

        }


        for (Long consoles: idConsoles
        ) {

            Console consolesToBuy = consoleRepository.findConsoleById(consoles);

            consoleStock = consolesToBuy.getStock();

            if (identify.equalsIgnoreCase("sale")){

                consoleStock--;

                consolesToBuy.setStock(consoleStock);

                consoleRepository.save(consolesToBuy);

                total+= consolesToBuy.getSellPrice();
            }

            if (identify.equalsIgnoreCase("devolution")){

                consoleStock++;

                consolesToBuy.setStock(consoleStock);

                consoleRepository.save(consolesToBuy);

                total-= consolesToBuy.getSellPrice();
            }
        }

        return total;
    }
}
