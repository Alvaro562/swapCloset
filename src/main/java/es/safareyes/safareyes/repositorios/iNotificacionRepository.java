package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Notificacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iNotificacionRepository extends JpaRepository<Notificacion, Integer> {

    List<Notificacion> findByIdPerfilAndLeidaFalseOrderByFechaDesc(Integer idPerfil);
    Page<Notificacion> findByIdPerfilAndLeida(Integer idPerfil, Boolean leida, Pageable pageable);
    long countByIdPerfilAndLeidaFalse(Integer idPerfil);
}