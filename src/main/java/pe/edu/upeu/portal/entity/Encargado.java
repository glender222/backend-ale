package pe.edu.upeu.portal.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "encargado")
public class Encargado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idencargado")
    private Long idencargado;

    @ManyToOne
    @JoinColumn(name = "personas", nullable = false)
    private Persona persona;

    @ManyToMany
    @JoinTable(
        name = "requisito_encargado",
        joinColumns = @JoinColumn(name = "idencargado"),
        inverseJoinColumns = @JoinColumn(name = "idrequisitos")
    )
    private Set<Requisitos> requisitos;
}
