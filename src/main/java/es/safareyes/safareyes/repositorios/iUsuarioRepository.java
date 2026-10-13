package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
