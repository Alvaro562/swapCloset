package es.safareyes.safareyes.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "id_perfil")
    private Integer idPerfil;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "contrasena", length = 255)
    private String contrasena;

    @Column(name = "rol", length = 30)
    private String rol;
}