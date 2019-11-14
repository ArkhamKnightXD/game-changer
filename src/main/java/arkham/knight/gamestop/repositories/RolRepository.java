package arkham.knight.gamestop.repositories;
import arkham.knight.gamestop.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findRolById(Long id);
}
