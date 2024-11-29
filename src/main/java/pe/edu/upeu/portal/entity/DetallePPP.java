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
@Table(name = "detallePPP")
public class DetallePPP {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddetallePPP")
	private Long iddetallePPP;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "area")
	private String area;
	@Column(name = "historial")
	private String historial;
	@Column(name = "comentarios")
	private String comentarios;
	@ManyToOne
    @JoinColumn(name="estados", nullable = false)
    private Estado estado;
	@ManyToOne
    @JoinColumn(name="procesoplanrequisitos", nullable = false)
    private ProcesoPlanRequisito procesoPlanRequisito;
	@ManyToOne
    @JoinColumn(name="ppps", nullable = false)
    private PPP ppp;
	@ManyToOne
    @JoinColumn(name="personas", nullable = false)
    private Persona persona;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "detallePPP")
    @JsonIgnore
    private Set<DetalleDoc> detalleDocs ;
}
