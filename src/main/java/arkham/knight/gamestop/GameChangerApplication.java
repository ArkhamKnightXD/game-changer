package arkham.knight.gamestop;
import arkham.knight.gamestop.controllers.ConsoleController;
import arkham.knight.gamestop.controllers.VideoGameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.io.File;

@SpringBootApplication
@ComponentScan({"arkham.knight.gamestop","arkham.knight.gamestop.controllers"})
public class GameChangerApplication {

    public static void main(String[] args) {

        new File(ConsoleController.uploadDirectory).mkdir();

        new File(VideoGameController.uploadDirectory).mkdir();

        SpringApplication.run(GameChangerApplication.class, args);

    }

}
