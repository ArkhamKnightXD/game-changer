package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.VideoGame;
import arkham.knight.gamestop.repositories.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoGameServices {

    @Autowired
    private VideoGameRepository videoGameRepository;


    public void createVideoGame(VideoGame console){

        videoGameRepository.save(console);
    }


    public List<VideoGame> listAllVideoGames(){

        return videoGameRepository.findAll();
    }


    public List<VideoGame> listAllVideoGamesByGenre(String genre){

        return videoGameRepository.findAllByGenre(genre);
    }


    public VideoGame findVideoGameById(long id){

        return videoGameRepository.findVideoGameById(id);
    }


    public List<VideoGame> findAllVideoGamesByPlatformName(String platformName){

        return videoGameRepository.findAllByPlatformsListName(platformName);
    }


    public List<VideoGame> findAllVideoGamesByRating(float rating){

        return videoGameRepository.findAllByRating(rating);
    }


    public VideoGame findVideoGameByRating(float rating){

        return videoGameRepository.findVideoGameByRating(rating);
    }


    public VideoGame findVideoGameByUnitsSold(double units){

        return videoGameRepository.findVideoGameByUnitsSold(units);
    }


    public void deleteVideoGame(VideoGame videoGame){

        videoGameRepository.delete(videoGame);
    }


    public void deleteAllVideoGames(){

        videoGameRepository.deleteAll();
    }
}
