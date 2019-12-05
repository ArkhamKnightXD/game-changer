package arkham.knight.gamestop.services;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class ApiServices {

    HttpResponse<JsonNode> response = Unirest.get("https://rawg-video-games-database.p.rapidapi.com/games")
            .header("x-rapidapi-host", "rawg-video-games-database.p.rapidapi.com")
            .header("x-rapidapi-key", "9e8a685e28msh1891b64fd114517p189639jsn2698bda73845")
            .asJson();


    public ApiServices() throws UnirestException {
    }


    public JsonNode getResponse() {

        return response.getBody();
    }
}
