package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface iEstiloRepository extends JpaRepository<Estilo, Integer> {

    Optional<Estilo> findByNombreIgnoreCase(String nombre);
    List<Estilo> findByIdIn(Collection<Integer> ids);
}