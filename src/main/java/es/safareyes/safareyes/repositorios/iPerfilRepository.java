package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface iPerfilRepository extends JpaRepository<Perfil, Integer> {

    Optional<Perfil> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
    List<Perfil> findByCiudadIgnoreCase(String ciudad);
    long countByCiudadIgnoreCase(String ciudad);
}