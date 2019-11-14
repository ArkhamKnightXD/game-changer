package arkham.knight.gamestop.repositories;

import arkham.knight.gamestop.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    Sale findSaleById(Long id);
}
