package arkham.knight.gamestop.repositories;
import arkham.knight.gamestop.models.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

    VideoGame findVideoGameById(long id);

    List<VideoGame> findAllByGenre(String genre);
}
