package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.PerfilEstilo;
import es.safareyes.safareyes.modelos.PerfilEstiloId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iPerfilEstiloRepository extends JpaRepository<PerfilEstilo, PerfilEstiloId> {

    List<PerfilEstilo> findByIdIdPerfil(Integer idPerfil);
    long countByIdIdPerfil(Integer idPerfil);
    boolean existsByIdIdPerfilAndIdIdEstilo(Integer idPerfil, Integer idEstilo);
}