package pe.edu.upeu.portal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "detalleevaluacion")
public class DetalleEvaluacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddetalleevaluacion")
	private Long iddetalleevaluacion;
	@Column(name = "peso")
	private int peso;
	@ManyToOne
    @JoinColumn(name="rubros", nullable = false)
    private Rubro rubro;
	@ManyToOne
    @JoinColumn(name="plancarrera", nullable = false)
    private PlanCarrera planCarrera;
}
