package es.safareyes.safareyes.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfil_estilo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilEstilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne
    @MapsId("idEstilo")
    @JoinColumn(name = "id_estilo")
    private Estilo estilo;
}