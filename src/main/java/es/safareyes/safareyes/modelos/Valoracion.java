package es.safareyes.safareyes.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "valoracion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valoracion")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Perfil autor;

    @ManyToOne
    @JoinColumn(name = "id_valorado")
    private Perfil valorado;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @Column(name = "comentario", columnDefinition = "text")
    private String comentario;

    @Column(name = "fecha")
    private LocalDateTime fecha;
}