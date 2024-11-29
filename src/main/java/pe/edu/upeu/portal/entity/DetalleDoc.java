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
@Table(name = "detalleDoc")
public class DetalleDoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddetalleDoc")
	private Long iddetalleDoc;
	@Column(name = "documento")
	private String documento;
	@Column(name = "fecha")
	private Date Fecha;
	@ManyToOne
    @JoinColumn(name="detalleppp", nullable = false)
    private DetallePPP detallePPP;
	@ManyToOne
    @JoinColumn(name="estados", nullable = false)
    private Estado estado;
}
