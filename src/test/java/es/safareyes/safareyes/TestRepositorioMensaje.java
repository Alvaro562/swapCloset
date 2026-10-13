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
public class TestRepositorioMensaje {

    @Autowired
    private iMensajeRepository repository;

    @Test
    void conversacionEntreDosPerfiles() {
        List<Mensaje> todos = repository
                .findByIdEmisorAndIdReceptorOrderByFechaEnvioAscHoraEnvioAsc(1, 2);
        assertNotNull(todos);
    }

    @Test
    void mensajesEnviadosORecibidos() {
        List<Mensaje> todos = repository
                .findByIdEmisorOrIdReceptorOrderByFechaEnvioDescHoraEnvioDesc(1, 1);
        assertNotNull(todos);
    }

    @Test
    void ultimoMensajeRecibido() {
        Optional<Mensaje> mensaje = repository
                .findFirstByIdReceptorOrderByFechaEnvioDescHoraEnvioDesc(1);
        assertNotNull(mensaje);
    }
}
