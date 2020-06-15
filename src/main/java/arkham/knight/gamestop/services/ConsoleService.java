package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.repositories.ConsoleRepository;
import arkham.knight.gamestop.repositories.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ConsoleService {

    @Autowired
    private ConsoleRepository consoleRepository;

    @Autowired
    private VideoGameRepository videoGameRepository;


    public void createConsole(Console console){

        consoleRepository.save(console);
    }


    public List<Console> listAllConsoles(){

        return consoleRepository.findAll();
    }


    public List<Console> listConsolesByType(String consoleType){

        return consoleRepository.findAllByConsoleType(consoleType);
    }


    public List<Console> listConsolesByGeneration(int generation){

        return consoleRepository.findAllByGeneration(generation);
    }


    public List<Console> findAllConsoleByDeveloper(String developer){

        return consoleRepository.findAllByDeveloper(developer);
    }


    public Console findConsoleById(Long id){

        if (id != null){

            return consoleRepository.findConsoleById(id);
        }

        else
            return null;
    }


    public List<Console> findAllConsolesById(List<Long> idConsoles){

        return consoleRepository.findAllById(idConsoles);
    }


    public Console findConsoleByName(String name){

        return consoleRepository.findConsoleByName(name);
    }


    public Console findConsoleByGeneration(int generation){

        return consoleRepository.findConsoleByGeneration(generation);
    }


    public int calculateLifeSpanOfTheConsole(Date releasedDate, Date discontinuedDate){

        Calendar releasedYear = Calendar.getInstance();

        Calendar discontinuedYear = Calendar.getInstance();

        releasedYear.setTime(releasedDate);

        discontinuedYear.setTime(discontinuedDate);

        return (discontinuedYear.get(Calendar.YEAR) - releasedYear.get(Calendar.YEAR));
    }


    public int convertFromStringToIntAndSetTheUnitsSold(String unitSold, String identifier, Long objectId){

        int units = 0;

        if (unitSold.equalsIgnoreCase("empty") && identifier.equalsIgnoreCase("Console")){

            Console consoleToEdit = consoleRepository.findConsoleById(objectId);

            return consoleToEdit.getUnitsSold();
        }


        if (unitSold.equalsIgnoreCase("empty") && identifier.equalsIgnoreCase("VideoGame")){

            VideoGame videoGame = videoGameRepository.findVideoGameById(objectId);

            return videoGame.getUnitsSold();
        }


        else{

            try {

                units = Integer.parseInt(unitSold);
            }
            catch (NumberFormatException e)
            {
                units = 0;
            }
        }

        return units;
    }


    public float convertFromStringToFloatAndSetThePrice(String sellPrice, String identifier, Long objectId){

        float sellingPrice = 0;

        if (sellPrice.equalsIgnoreCase("empty") && identifier.equalsIgnoreCase("Console")){

            Console consoleToEdit = consoleRepository.findConsoleById(objectId);

            return consoleToEdit.getSellPrice();
        }


        if (sellPrice.equalsIgnoreCase("empty") && identifier.equalsIgnoreCase("VideoGame")){

            VideoGame videoGame = videoGameRepository.findVideoGameById(objectId);

            return videoGame.getSellPrice();
        }


        else{

            try {

                sellingPrice = Float.parseFloat(sellPrice);
            }
            catch (NumberFormatException e)
            {
                sellingPrice = 0;
            }
        }

        return sellingPrice;
    }


    public Date convertFromStringToDateAndSetTheDate(String releasedDate, String identifier, Long objectId){

        Date date = null;

        if (releasedDate.equalsIgnoreCase("empty") && identifier.equalsIgnoreCase("VideoGame")){

            VideoGame videoGame = videoGameRepository.findVideoGameById(objectId);

            return videoGame.getReleasedDate();
        }


        if (releasedDate.equalsIgnoreCase("empty") && identifier.equalsIgnoreCase("ReleasedDate")){

            Console console = consoleRepository.findConsoleById(objectId);

            return console.getReleasedDate();
        }


        if (releasedDate.equalsIgnoreCase("empty") && identifier.equalsIgnoreCase("DiscontinuedDate")){

            Console console = consoleRepository.findConsoleById(objectId);

            return console.getDiscontinuedDate();
        }


        try {

            date = new SimpleDateFormat("yyyy-MM-dd").parse(releasedDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }


    public void deleteConsole(Long id){

        consoleRepository.deleteById(id);
    }


    public void deleteAllConsoles(){

        consoleRepository.deleteAll();
    }
}
