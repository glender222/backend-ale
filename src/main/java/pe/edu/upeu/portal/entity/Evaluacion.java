package pe.edu.upeu.portal.entity;

import java.sql.Date;

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
@Table(name = "evaluacione")
public class Evaluacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idevaluacion")
	private Long idevaluacion;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "nota")
	private int nota;
	@ManyToOne
    @JoinColumn(name="ppps", nullable = false)
    private PPP ppp;
	@ManyToOne
    @JoinColumn(name="rubros", nullable = false)
    private Rubro rubro;
}
