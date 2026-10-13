package es.safareyes.safareyes.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notificacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Integer id;

    @Column(name = "id_perfil")
    private Integer idPerfil;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "mensaje", columnDefinition = "text")
    private String mensaje;

    @Column(name = "leida")
    private Boolean leida;

    @Column(name = "fecha")
    private LocalDateTime fecha;
}