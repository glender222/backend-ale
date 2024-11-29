package pe.edu.upeu.portal.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "requisito")
public class Requisitos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrequisitos")
    private Long idrequisitos;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "estados", nullable = false)
    private Estado estado;

    @ManyToMany(mappedBy = "requisitos")
    private Set<Encargado> encargados;
}
