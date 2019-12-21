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


    public void createVideoGame(VideoGame videoGame){

        videoGameRepository.save(videoGame);
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


    public List<VideoGame> findAllVideoGamesById(List<Long> idVideoGames){

        return videoGameRepository.findAllById(idVideoGames);
    }


    public List<VideoGame> findAllVideoGamesByPlatformName(String platformName){

        return videoGameRepository.findAllByPlatformsListName(platformName);
    }


    public List<VideoGame> findAllVideoGamesByRating(float rating){

        return videoGameRepository.findAllByRating(rating);
    }


    public VideoGame findVideoGameByUnitsSold(int units){

        return videoGameRepository.findVideoGameByUnitsSold(units);
    }


    public void deleteVideoGame(Long id){

        videoGameRepository.deleteById(id);
    }


    public void deleteAllVideoGames(){

        videoGameRepository.deleteAll();
    }


    public float convertFromStringToFloatAndSetTheRating(String rating, Long objectId){

        float ratingExtra = 0;

        VideoGame videoGame = videoGameRepository.findVideoGameById(objectId);

        try {

            ratingExtra = Float.parseFloat(rating);
        }
        catch (NumberFormatException e)
        {
            ratingExtra = 0;
        }


        if (ratingExtra == 0){

            return videoGame.getRating();
        }

        else {

            return ratingExtra;
        }
    }
}
