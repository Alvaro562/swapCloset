package es.safareyes.safareyes.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "solicitud_prenda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudPrenda {

    @EmbeddedId
    private Integer id;

    @ManyToOne
    @MapsId("idSolicitud")
    @JoinColumn(name = "id_solicitud")
    private Solicitud solicitud;

    @ManyToOne
    @MapsId("idPrenda")
    @JoinColumn(name = "id_prenda")
    private Prenda prenda;
}