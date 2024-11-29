package pe.edu.upeu.portal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idusuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contraseña")
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "personas", nullable = false)
    private Persona persona;

    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioRol> usuarioRoles;
}
