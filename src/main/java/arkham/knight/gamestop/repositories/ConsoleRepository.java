package arkham.knight.gamestop.repositories;

import arkham.knight.gamestop.models.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console,Long> {

     Console findConsoleById(long id);

}
