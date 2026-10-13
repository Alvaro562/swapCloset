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
public class TestRepositorioValoracion {

    @Autowired
    private iValoracionRepository repository;

    @Test
    void buscarPorValorado() {
        List<Valoracion> todas = repository.findByValoradoId(1);
        assertNotNull(todas);
    }

    @Test
    void contarPorValorado() {
        long total = repository.countByValoradoId(1);
        assertTrue(total >= 0);
    }

    @Test
    void existeValoracionDeAutorAValorado() {
        boolean existe = repository.existsByAutorIdAndValoradoId(1, 2);
        System.out.println("Existe: " + existe);
    }

    @Test
    void buscarPorValoradoConPuntuacionMinima() {
        List<Valoracion> todas = repository
                .findByValoradoIdAndPuntuacionGreaterThanEqualOrderByFechaDesc(1, 4);
        assertNotNull(todas);
    }

    @Test
    void buscarPuntuacionesBajas() {
        List<Valoracion> todas = repository.findByPuntuacionLessThan(3);
        assertNotNull(todas);
    }
}
