package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iValoracionRepository extends JpaRepository<Valoracion, Integer> {

    List<Valoracion> findByValoradoId(Integer idPerfil);
    long countByValoradoId(Integer idPerfil);
    boolean existsByAutorIdAndValoradoId(Integer idAutor, Integer idValorado);
    List<Valoracion> findByValoradoIdAndPuntuacionGreaterThanEqualOrderByFechaDesc(Integer idPerfil, Integer minimo);
    List<Valoracion> findByPuntuacionLessThan(Integer puntuacion);
}