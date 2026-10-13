package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface iMensajeRepository extends JpaRepository<Mensaje, Integer> {

    List<Mensaje> findByIdEmisorAndIdReceptorOrderByFechaEnvioAscHoraEnvioAsc(Integer emisor, Integer receptor);
    List<Mensaje> findByIdEmisorOrIdReceptorOrderByFechaEnvioDescHoraEnvioDesc(Integer emisor, Integer receptor);
    Optional<Mensaje> findFirstByIdReceptorOrderByFechaEnvioDescHoraEnvioDesc(Integer idReceptor);
}