package arkham.knight.gamestop.repositories;

import arkham.knight.gamestop.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    Venta findVentaById(Long id);
}
