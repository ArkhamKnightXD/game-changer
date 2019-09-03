package arkham.knight.gamestop.repositories;

import arkham.knight.gamestop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(long id);

    User findUserByUsername(String username);
}
