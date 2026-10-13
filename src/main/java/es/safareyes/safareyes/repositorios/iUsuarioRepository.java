package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<Usuario> findByIdPerfil(Integer idPerfil);
    List<Usuario> findByRol(String rol);
}