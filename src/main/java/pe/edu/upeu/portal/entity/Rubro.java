package pe.edu.upeu.portal.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "rubro")
public class Rubro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrubro")
	private Long idrubro;
	@Column(name = "nombre")
	private String nombre;
	@ManyToOne
    @JoinColumn(name="estados", nullable = false)
    private Estado estado;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "rubro")
    @JsonIgnore
    private Set<DetalleEvaluacion> detalleEvaluaciones ;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "rubro")
    @JsonIgnore
    private Set<Evaluacion> evaluaciones ;
}
