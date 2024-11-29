package pe.edu.upeu.portal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Long idrol;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "estados", nullable = false)
    private Estado estado;

    @OneToMany(mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles;
    
    @ManyToMany
    @JoinTable(
        name = "roles_privilegios", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "idrol"), // Clave foránea de `Rol`
        inverseJoinColumns = @JoinColumn(name = "idprivilegios") // Clave foránea de `Privilegios`
    )
    private Set<Privilegios> privilegios;
}
