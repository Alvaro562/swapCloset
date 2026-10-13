package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface iFotoRepository extends JpaRepository<Foto, Integer> {

    List<Foto> findByPrendaIdOrderByOrdenAsc(Integer idPrenda);
    Optional<Foto> findFirstByPrendaIdOrderByOrdenAsc(Integer idPrenda);
    long countByPrendaId(Integer idPrenda);
}