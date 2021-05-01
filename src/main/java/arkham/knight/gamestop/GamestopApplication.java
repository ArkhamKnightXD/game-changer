package arkham.knight.gamestop;

import arkham.knight.gamestop.controllers.ClientController;
import arkham.knight.gamestop.controllers.ConsoleController;
import arkham.knight.gamestop.controllers.UserController;
import arkham.knight.gamestop.controllers.VideoGameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.io.File;

@SpringBootApplication
@ComponentScan({"arkham.knight.gamestop","arkham.knight.gamestop.controllers"})
public class GamestopApplication {

    public static void main(String[] args) {

        new File(ConsoleController.uploadDirectory).mkdir();

        new File(VideoGameController.uploadDirectory).mkdir();

        new File(UserController.uploadDirectory).mkdir();

        new File(ClientController.uploadDirectory).mkdir();

        SpringApplication.run(GamestopApplication.class, args);
    }

}
