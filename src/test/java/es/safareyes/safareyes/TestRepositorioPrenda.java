package es.safareyes.safareyes;

import es.safareyes.safareyes.modelos.*;
import es.safareyes.safareyes.repositorios.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestRepositorioPrenda {

    @Autowired
    private iPrendaRepository repository;

    @Test
    void buscarPorPerfil() {
        List<Prenda> todas = repository.findByPerfilId(1);
        assertNotNull(todas);
    }

    @Test
    void buscarPorCategoriaDisponibles() {
        List<Prenda> todas = repository.findByCategoriaIdAndDisponibilidadTrue(1);
        assertNotNull(todas);
    }

    @Test
    void buscarPorTallaYEstadoDisponibles() {
        List<Prenda> todas = repository.findByTallaAndEstadoAndDisponibilidadTrue("M", "Nuevo");
        assertNotNull(todas);
    }

    @Test
    void buscarPorTituloIgnoreCase() {
        List<Prenda> todas = repository.findByTituloContainingIgnoreCaseAndDisponibilidadTrue("camisa");
        assertNotNull(todas);
    }

    @Test
    void buscarDisponiblesEntreFechas() {
        LocalDateTime desde = LocalDateTime.now().minusYears(1);
        LocalDateTime hasta = LocalDateTime.now();
        List<Prenda> todas = repository
                .findByDisponibilidadTrueAndFechaPublicacionBetweenOrderByFechaPublicacionDesc(desde, hasta);
        assertNotNull(todas);
    }

    @Test
    void buscarTop5Recientes() {
        List<Prenda> todas = repository.findTop5ByDisponibilidadTrueOrderByFechaPublicacionDesc();
        assertNotNull(todas);
        assertTrue(todas.size() <= 5);
    }

    @Test
    void buscarUltimaPrendaDePerfil() {
        Optional<Prenda> prenda = repository.findFirstByPerfilIdOrderByFechaPublicacionDesc(1);
        assertNotNull(prenda);
    }

    @Test
    void contarDisponiblesPorPerfil() {
        long total = repository.countByPerfilIdAndDisponibilidadTrue(1);
        assertTrue(total >= 0);
    }
}
