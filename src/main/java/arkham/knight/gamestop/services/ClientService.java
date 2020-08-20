package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Client;
import arkham.knight.gamestop.repositories.ClientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public void createClient(Client client){

        clientRepository.save(client);
    }


    public void saveAllClients(InputStream inputStream, TypeReference<List<Client>> typeReference){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Client> clients = objectMapper.readValue(inputStream,typeReference);

            clientRepository.saveAll(clients);

            System.out.println("Clients Saved!");

        } catch (IOException e){

            System.out.println("Unable to save clients: " + e.getMessage());
        }

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
