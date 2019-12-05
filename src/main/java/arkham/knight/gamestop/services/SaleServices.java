package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.models.Sale;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.repositories.ConsoleRepository;
import arkham.knight.gamestop.repositories.SaleRepository;
import arkham.knight.gamestop.repositories.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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

        int consoleStock =0;

        int videoGameStock = 0;

        float total = 0;


        for (Long videoGamesId: idVideoGames
        ) {

                VideoGame videoGameToBuy = videoGameRepository.findVideoGameById(videoGamesId);

                videoGameStock = videoGameToBuy.getStock()-1;

                videoGameToBuy.setStock(videoGameStock);

                videoGameRepository.save(videoGameToBuy);

                total+= videoGameToBuy.getSellPrice();
        }


        for (Long consolesId: idConsoles
        ) {

                Console consolesToBuy = consoleRepository.findConsoleById(consolesId);

                consoleStock = consolesToBuy.getStock()-1;

                consolesToBuy.setStock(consoleStock);

                consoleRepository.save(consolesToBuy);

                total+= consolesToBuy.getSellPrice();
        }

        return total;
    }


    public List<Console> removeConsoleAndCalculateTotalFromTheSale(List<Console> consolesSoldList, List<Long> idConsoles, Sale devolutionSale){

        int consoleStock = 0;

        float salesTotal;

        List<Console> consoleList = new ArrayList<>();


        for (Console consoles : consolesSoldList) {

            for (Long consolesIds: idConsoles) {

                Console consoleToMakeADevolution = consoleRepository.findConsoleById(consolesIds);

                if (consoles.getId() == consoleToMakeADevolution.getId()){

                    salesTotal = devolutionSale.getTotal();

                    salesTotal -= consoleToMakeADevolution.getSellPrice();

                    devolutionSale.setTotal(salesTotal);

                    consoleStock = consoleToMakeADevolution.getStock()+1;

                    consoleToMakeADevolution.setStock(consoleStock);

                    consoleRepository.save(consoleToMakeADevolution);

                    saleRepository.save(devolutionSale);
                }

                else {

                    consoleList.add(consoles);
                }

            }

        }

        return consoleList;
    }


    public List<VideoGame> removeVideoGameAndCalculateTotalFromTheSale(List<VideoGame> videoGameSoldList, List<Long> idVideoGames, Sale devolutionSale){

        int videoGameStock = 0;

        float salesTotal;

        List<VideoGame> videoGameList = new ArrayList<>();


        for (VideoGame videoGames : videoGameSoldList) {

            for (Long videoGameIds: idVideoGames) {

                VideoGame videoGameToMakeADevolution = videoGameRepository.findVideoGameById(videoGameIds);

                if (videoGames.getId() == videoGameToMakeADevolution.getId()){

                    salesTotal = devolutionSale.getTotal();

                    salesTotal -= videoGameToMakeADevolution.getSellPrice();

                    devolutionSale.setTotal(salesTotal);

                    videoGameStock = videoGameToMakeADevolution.getStock()+1;

                    videoGameToMakeADevolution.setStock(videoGameStock);

                    videoGameRepository.save(videoGameToMakeADevolution);

                    saleRepository.save(devolutionSale);
                }

                else {

                    videoGameList.add(videoGames);
                }

            }

        }

        return videoGameList;
    }
}
