package pe.edu.upeu.portal.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "privilegio")
public class Privilegios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprivilegios")
    private Long idprivilegios;

    @Column(name = "tipos")
    private String tipos;

    @ManyToOne
    @JoinColumn(name = "estados", nullable = false)
    private Estado estado;

    @ManyToMany(mappedBy = "privilegios")
    private Set<Rol> roles;
}
