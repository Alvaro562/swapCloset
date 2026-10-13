package es.safareyes.safareyes.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "mensajes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private Integer id;

    @Column(name = "id_perfil_emisor")
    private Integer idEmisor;

    @Column(name = "id_perfil_receptor")
    private Integer idReceptor;

    @Column(name = "contenido", columnDefinition = "text")
    private String contenido;

    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio;

    @Column(name = "hora_envio")
    private LocalTime horaEnvio;
}