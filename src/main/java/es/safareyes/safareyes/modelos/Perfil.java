package es.safareyes.safareyes.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "perfil")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Integer id;

    @Column(name = "id_cuenta")
    private Integer idCuenta;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "apellido1", length = 100)
    private String apellido1;

    @Column(name = "apellido2", length = 100)
    private String apellido2;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "ciudad", length = 100)
    private String ciudad;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "biografia", columnDefinition = "text")
    private String biografia;

    @Column(name = "talla_camiseta", length = 10)
    private String tallaCamiseta;

    @Column(name = "talla_pantalon", length = 10)
    private String tallaPantalon;

    @Column(name = "talla_zapatos", length = 20)
    private String tallaZapatos;
}