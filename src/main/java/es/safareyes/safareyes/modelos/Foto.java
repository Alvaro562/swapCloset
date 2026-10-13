package es.safareyes.safareyes.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "foto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_prenda")
    private Prenda prenda;

    @Column(name = "url", columnDefinition = "text")
    private String url;

    @Column(name = "orden")
    private Integer orden;
}