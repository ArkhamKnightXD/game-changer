package arkham.knight.gamestop.repositories;
import arkham.knight.gamestop.models.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsoleRepository extends JpaRepository<Console,Long> {

     Console findConsoleById(long id);

     List<Console> findAllByConsoleType(String consoleType);

     List<Console> findAllByGeneration(String generation);

     List<Console> findAllByDeveloper(String developer);

     Console findConsoleByUnitsSold(double units);

}
