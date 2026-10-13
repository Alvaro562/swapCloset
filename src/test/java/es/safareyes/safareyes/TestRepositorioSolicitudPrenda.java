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
public class TestRepositorioSolicitudPrenda {

    @Autowired
    private iSolicitudPrendaRepository repository;

    @Test
    void buscarPorSolicitud() {
        List<SolicitudPrenda> todas = repository.findByIdIdSolicitud(1);
        assertNotNull(todas);
    }

    @Test
    void buscarPorPrenda() {
        List<SolicitudPrenda> todas = repository.findByPrendaId(1);
        assertNotNull(todas);
    }

    @Test
    void contarPorPrenda() {
        long total = repository.countByPrendaId(1);
        assertTrue(total >= 0);
    }
}
