package arkham.knight.gamestop.repositories;
import arkham.knight.gamestop.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientById(Long id);

    Client findClientByNameAndLastName(String name, String lastName);
}
