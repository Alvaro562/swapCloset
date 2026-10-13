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
public class TestRepositorioPerfil {

    @Autowired
    private iPerfilRepository repository;

    @Test
    void buscarPorEmail() {
        Optional<Perfil> perfil = repository.findByEmailIgnoreCase("test@safareyes.es");
        assertNotNull(perfil);
    }

    @Test
    void existePorEmail() {
        boolean existe = repository.existsByEmailIgnoreCase("test@safareyes.es");
        System.out.println("Existe: " + existe);
    }

    @Test
    void buscarPorCiudad() {
        List<Perfil> todos = repository.findByCiudadIgnoreCase("madrid");
        assertNotNull(todos);
    }

    @Test
    void contarPorCiudad() {
        long total = repository.countByCiudadIgnoreCase("madrid");
        assertTrue(total >= 0);
    }
}
