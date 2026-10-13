package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface iSolicitudRepository extends JpaRepository<Solicitud, Integer> {

    List<Solicitud> findByIdSolicitanteOrderByFechaCreacionDesc(Integer idSolicitante);
    List<Solicitud> findByEstado(String estado);
    long countByIdSolicitanteAndTipoSolicitudAndEstadoIn(Integer idSolicitante, String tipoSolicitud,
                                                         Collection<String> estados);
    List<Solicitud> findByEstadoAndFechaCreacionBefore(String estado, LocalDateTime limite);
    List<Solicitud> findByTipoSolicitudAndEstadoAndFechaFinLessThan(String tipo, String estado, LocalDate hoy);
    List<Solicitud> findByTipoSolicitudAndEstadoAndFechaFin(String tipo, String estado, LocalDate fecha);
}