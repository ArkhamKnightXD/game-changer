package arkham.knight.gamestop;
import arkham.knight.gamestop.controllers.ClientController;
import arkham.knight.gamestop.controllers.ConsoleController;
import arkham.knight.gamestop.controllers.UserController;
import arkham.knight.gamestop.controllers.VideoGameController;
import arkham.knight.gamestop.models.Client;
import arkham.knight.gamestop.services.ClientService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import java.io.File;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@ComponentScan({"arkham.knight.gamestop","arkham.knight.gamestop.controllers"})
public class GameChangerApplication {

    public static void main(String[] args) {

        new File(ConsoleController.uploadDirectory).mkdir();

        new File(VideoGameController.uploadDirectory).mkdir();

        new File(UserController.uploadDirectory).mkdir();

        new File(ClientController.uploadDirectory).mkdir();

        SpringApplication.run(GameChangerApplication.class, args);

    }


    @Bean
    CommandLineRunner runner(ClientService clientService){
        return args -> {



            TypeReference<List<Client>> typeReference = new TypeReference<List<Client>>(){};

            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/clients.json");

          //  clientService.saveAllClients(inputStream,typeReference);
        };
    };
}
