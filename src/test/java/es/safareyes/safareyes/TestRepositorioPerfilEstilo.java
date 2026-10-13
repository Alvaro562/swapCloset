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
public class TestRepositorioPerfilEstilo {

    @Autowired
    private iPerfilEstiloRepository repository;

    @Test
    void buscarPorPerfil() {
        List<PerfilEstilo> todos = repository.findByIdIdPerfil(1);
        assertNotNull(todos);
    }

    @Test
    void contarPorPerfil() {
        long total = repository.countByIdIdPerfil(1);
        assertTrue(total >= 0);
    }

    @Test
    void existePerfilConEstilo() {
        boolean existe = repository.existsByIdIdPerfilAndIdIdEstilo(1, 1);
        System.out.println("Existe: " + existe);
    }
}
