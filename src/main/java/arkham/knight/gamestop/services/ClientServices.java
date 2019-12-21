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


    public void saveAllClients(List<Client> clients){

        clientRepository.saveAll(clients);
    }


    public List<Client> listAllClients(){

        return clientRepository.findAll();
    }


    public Client findClientById(long id){

        return clientRepository.findClientById(id);
    }


    public void deleteClient(Long id){

        clientRepository.deleteById(id);
    }


    public void deleteAllClients(){

        clientRepository.deleteAll();
    }
}
