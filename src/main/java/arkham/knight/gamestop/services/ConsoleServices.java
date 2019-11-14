package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Console;
import arkham.knight.gamestop.repositories.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


    public Console findConsoleByUnitsSold(double units){

        return consoleRepository.findConsoleByUnitsSold(units);
    }


    public Console findConsoleById(long id){

        return consoleRepository.findConsoleById(id);
    }


    public Console findConsoleByName(String name){

        return consoleRepository.findConsoleByName(name);
    }


    public Console findConsoleByGeneration(int generation){

        return consoleRepository.findConsoleByGeneration(generation);
    }


    public void deleteConsole(Console console){

        consoleRepository.delete(console);
    }


    public void deleteAllConsoles(){

        consoleRepository.deleteAll();
    }
}
