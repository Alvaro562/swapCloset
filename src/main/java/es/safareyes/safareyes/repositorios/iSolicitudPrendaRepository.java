package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.SolicitudPrenda;
import es.safareyes.safareyes.modelos.SolicitudPrendaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iSolicitudPrendaRepository extends JpaRepository<SolicitudPrenda, SolicitudPrendaId> {

    List<SolicitudPrenda> findByIdIdSolicitud(Integer idSolicitud);
    List<SolicitudPrenda> findByPrendaId(Integer idPrenda);
    long countByPrendaId(Integer idPrenda);
}