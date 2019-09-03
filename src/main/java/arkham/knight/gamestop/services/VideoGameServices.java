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

    public VideoGame findVideoGameById(long id){

        return videoGameRepository.findVideoGameById(id);
    }


    public void deleteVideoGame(VideoGame videoGame){

        videoGameRepository.delete(videoGame);
    }

}
