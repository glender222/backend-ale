package pe.edu.upeu.portal.entity;

import java.sql.Date;
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
@Table(name = "ppp")
public class PPP {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idppp")
	private Long idppp;
	@Column(name = "horario")
	private String horario;
	@Column(name = "fechainicio")
	private Date fechainicio;
	@Column(name = "fechafinal")
	private Date fechafinal;
	@Column(name = "horastrabajo")
	private int horastrabajo;
	@ManyToOne
    @JoinColumn(name="empresas", nullable = false)
    private Empresa empresa;
	@ManyToOne
    @JoinColumn(name="matriculas", nullable = false)
    private Matricula matricula;
	@ManyToOne
    @JoinColumn(name="plancarreras", nullable = false)
    private PlanCarrera planCarrera;
	@ManyToOne
    @JoinColumn(name="lineas", nullable = false)
    private Linea linea;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "ppp")
    @JsonIgnore
    private Set<Evaluacion> evaluaciones ;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "ppp")
    @JsonIgnore
    private Set<DetallePPP> detallePPPs ;
}
