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
@Table(name = "procesoPlanRequisito")
public class ProcesoPlanRequisito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idprocesoPlanRequisito")
	private Long idprocesoPlanRequisito;
	@ManyToOne
    @JoinColumn(name="procesos", nullable = false)
    private Proceso proceso;
	@ManyToOne
    @JoinColumn(name="plancarreras", nullable = false)
    private PlanCarrera planCarrera;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "procesoPlanRequisito")
    @JsonIgnore
    private Set<DetallePPP> detallePPPs ;
}
