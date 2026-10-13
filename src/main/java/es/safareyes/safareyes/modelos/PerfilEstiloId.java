package es.safareyes.safareyes.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PerfilEstiloId implements Serializable {

    @Column(name = "id_perfil")
    private Integer idPerfil;

    @Column(name = "id_estilo")
    private Integer idEstilo;
}