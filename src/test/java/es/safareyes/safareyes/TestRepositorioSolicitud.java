package es.safareyes.safareyes;

import es.safareyes.safareyes.modelos.*;
import es.safareyes.safareyes.repositorios.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestRepositorioSolicitud {

    @Autowired
    private iSolicitudRepository repository;

    @Test
    void buscarPorSolicitanteOrdenadas() {
        List<Solicitud> todas = repository.findByIdSolicitanteOrderByFechaCreacionDesc(1);
        assertNotNull(todas);
    }

    @Test
    void buscarPorEstado() {
        List<Solicitud> todas = repository.findByEstado("PENDIENTE");
        assertNotNull(todas);
    }

    @Test
    void contarPorSolicitanteTipoYEstados() {
        long total = repository.countByIdSolicitanteAndTipoSolicitudAndEstadoIn(
                1, "PRESTAMO", List.of("PENDIENTE", "ACEPTADA"));
        assertTrue(total >= 0);
    }

    @Test
    void buscarPorEstadoCreadasAntesDe() {
        List<Solicitud> todas = repository.findByEstadoAndFechaCreacionBefore(
                "PENDIENTE", LocalDateTime.now().minusDays(7));
        assertNotNull(todas);
    }

    @Test
    void buscarPorTipoEstadoYFechaFinAnterior() {
        List<Solicitud> todas = repository.findByTipoSolicitudAndEstadoAndFechaFinLessThan(
                "PRESTAMO", "ACEPTADA", LocalDate.now());
        assertNotNull(todas);
    }

    @Test
    void buscarPorTipoEstadoYFechaFin() {
        List<Solicitud> todas = repository.findByTipoSolicitudAndEstadoAndFechaFin(
                "PRESTAMO", "ACEPTADA", LocalDate.now());
        assertNotNull(todas);
    }
}
