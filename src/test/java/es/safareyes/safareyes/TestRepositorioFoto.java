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
public class TestRepositorioFoto {

    @Autowired
    private iFotoRepository repository;

    @Test
    void buscarPorPrendaOrdenadas() {
        List<Foto> todas = repository.findByPrendaIdOrderByOrdenAsc(1);
        assertNotNull(todas);
    }

    @Test
    void buscarPrimeraFotoDePrenda() {
        Optional<Foto> foto = repository.findFirstByPrendaIdOrderByOrdenAsc(1);
        assertNotNull(foto);
    }

    @Test
    void contarFotosPorPrenda() {
        long total = repository.countByPrendaId(1);
        assertTrue(total >= 0);
    }
}
