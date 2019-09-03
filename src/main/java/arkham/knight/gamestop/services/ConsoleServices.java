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

    public Console findConsoleById(long id){

        return consoleRepository.findConsoleById(id);
    }


    public void deleteConsole(Console console){

        consoleRepository.delete(console);
    }

}
