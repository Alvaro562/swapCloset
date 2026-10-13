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
public class TestRepositorioUsuario {

    @Autowired
    private iUsuarioRepository repository;

    @Test
    void buscarPorUsername() {
        Optional<Usuario> usuario = repository.findByUsername("admin");
        assertNotNull(usuario);
    }

    @Test
    void existePorUsername() {
        boolean existe = repository.existsByUsername("admin");
        System.out.println("Existe: " + existe);
    }

    @Test
    void buscarPorIdPerfil() {
        Optional<Usuario> usuario = repository.findByIdPerfil(1);
        assertNotNull(usuario);
    }

    @Test
    void buscarPorRol() {
        List<Usuario> todos = repository.findByRol("ADMIN");
        assertNotNull(todos);
    }
}
