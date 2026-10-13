package es.safareyes.safareyes;

import es.safareyes.safareyes.modelos.*;
import es.safareyes.safareyes.repositorios.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestRepositorioEstilo {

    @Autowired
    private iEstiloRepository repository;

    @Test
    void buscarPorNombre() {
        Optional<Estilo> estilo = repository.findByNombreIgnoreCase("casual");
        assertNotNull(estilo);
    }

    @Test
    void buscarPorListaDeIds() {
        List<Estilo> todos = repository.findByIdIn(List.of(1, 2, 3));
        assertNotNull(todos);
        assertTrue(todos.size() <= 3);
    }
}
