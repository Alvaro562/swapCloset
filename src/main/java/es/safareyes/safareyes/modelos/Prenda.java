package es.safareyes.safareyes.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "prenda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prenda")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Column(name = "titulo", length = 150)
    private String titulo;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "marca", length = 100)
    private String marca;

    @Column(name = "talla", length = 10)
    private String talla;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "disponibilidad")
    private Boolean disponibilidad;

    @Column(name = "permite_prest")
    private Boolean permitePrestamo;

    @Column(name = "permite_intercambio")
    private Boolean permiteIntercambio;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion;

    @OneToMany(mappedBy = "prenda")
    private List<Foto> fotos;
}