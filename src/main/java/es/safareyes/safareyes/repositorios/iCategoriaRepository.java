package es.safareyes.safareyes.repositorios;

import es.safareyes.safareyes.modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iCategoriaRepository extends JpaRepository<Categoria, Integer> {
}
