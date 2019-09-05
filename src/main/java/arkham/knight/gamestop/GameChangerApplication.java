package arkham.knight.gamestop;

import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.services.VideoGameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;


@SpringBootApplication
public class GameChangerApplication {

    @Autowired
    private VideoGameServices videoGameServices;

    public static void main(String[] args) {
        SpringApplication.run(GameChangerApplication.class, args);
    }

    public void run(){



    }

}
