package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.repositories.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ConsoleServices {

    @Autowired
    private ConsoleRepository consoleRepository;


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


    public Console findConsoleByUnitsSold(int units){

        return consoleRepository.findConsoleByUnitsSold(units);
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


    public int convertFromStringToIntAndSetTheUnitsSold(String unitSold, Console consoleToEdit){

        int units = 0;

        if (unitSold.equalsIgnoreCase("empty")){

            return consoleToEdit.getUnitsSold();
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


    public float convertFromStringToFloatAndSetThePrice(String sellPrice, Console consoleToEdit){

        float sellingPrice = 0;

        if (sellPrice.equalsIgnoreCase("empty")){

            return consoleToEdit.getSellPrice();
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


    public void deleteConsole(Long id){

        consoleRepository.deleteById(id);
    }


    public void deleteAllConsoles(){

        consoleRepository.deleteAll();
    }
}
