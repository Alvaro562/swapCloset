package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
    // La relación está en perfil.id_cuenta, no en cuenta
    @Query("select u from Usuario u, Perfil p where p.idCuenta = u.id and p.id = :idPerfil")
    Optional<Usuario> findByIdPerfil(@Param("idPerfil") Integer idPerfil);
    List<Usuario> findByRol(String rol);
}