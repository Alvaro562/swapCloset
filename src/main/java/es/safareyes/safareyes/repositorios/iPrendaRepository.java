package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface iPrendaRepository extends JpaRepository<Prenda, Integer> {

    List<Prenda> findByPerfilId(Integer idPerfil);
    List<Prenda> findByCategoriaIdAndDisponibilidadTrue(Integer idCategoria);
    List<Prenda> findByTallaAndEstadoAndDisponibilidadTrue(String talla, String estado);
    List<Prenda> findByTituloContainingIgnoreCaseAndDisponibilidadTrue(String texto);
    List<Prenda> findByDisponibilidadTrueAndFechaPublicacionBetweenOrderByFechaPublicacionDesc(
            LocalDateTime desde, LocalDateTime hasta);
    List<Prenda> findTop5ByDisponibilidadTrueOrderByFechaPublicacionDesc();
    Optional<Prenda> findFirstByPerfilIdOrderByFechaPublicacionDesc(Integer idPerfil);
    long countByPerfilIdAndDisponibilidadTrue(Integer idPerfil);
}