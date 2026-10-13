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
public class TestRepositorioCategoria {

    @Autowired
    private iCategoriaRepository repository;

    @Test
    void buscarPorNombre() {
        Optional<Categoria> categoria = repository.findByNombreIgnoreCase("camisas");
        assertNotNull(categoria);
    }

    @Test
    void existePorNombre() {
        boolean existe = repository.existsByNombreIgnoreCase("camisas");
        System.out.println("Existe: " + existe);
    }
}
