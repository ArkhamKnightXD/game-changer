package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Client;
import arkham.knight.gamestop.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;


    public void createClient(Client client){

        clientRepository.save(client);
    }


    public List<Client> listAllClients(){

        return clientRepository.findAll();
    }


    public Client findClientById(long id){

        return clientRepository.findClientById(id);
    }


    public Client findClientByNameAndLastName(String name, String lastName){

        return clientRepository.findClientByNameAndLastName(name,lastName);
    }


    public void deleteClient(Client client){

        clientRepository.delete(client);
    }


    public void deleteAllClients(){

        clientRepository.deleteAll();
    }
}
