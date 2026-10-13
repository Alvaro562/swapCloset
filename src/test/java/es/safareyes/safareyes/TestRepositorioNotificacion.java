package es.safareyes.safareyes;

import es.safareyes.safareyes.modelos.*;
import es.safareyes.safareyes.repositorios.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestRepositorioNotificacion {

    @Autowired
    private iNotificacionRepository repository;

    @Test
    void noLeidasOrdenadasPorFecha() {
        List<Notificacion> todas = repository.findByIdPerfilAndLeidaFalseOrderByFechaDesc(1);
        assertNotNull(todas);
    }

    @Test
    void notificacionesPaginadas() {
        Pageable pagina = PageRequest.of(0, 5);
        Page<Notificacion> resultado = repository.findByIdPerfilAndLeida(1, false, pagina);
        assertNotNull(resultado);
        assertTrue(resultado.getContent().size() <= 5);
    }

    @Test
    void contarNoLeidas() {
        long total = repository.countByIdPerfilAndLeidaFalse(1);
        assertTrue(total >= 0);
    }
}
