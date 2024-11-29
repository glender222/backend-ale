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
@Table(name = "persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpersona")
	private Long idpersona;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apepat")
	private String apepat;
	@Column(name = "apemat")
	private String apemat;
	@Column(name = "correo")
	private String correo;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "dni")
	private String dni;
	@ManyToOne
    @JoinColumn(name="estados", nullable = false)
    private Estado estado;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "persona")
    @JsonIgnore
    private Set<Encargado> encargados ;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "persona")
    @JsonIgnore
    private Set<Estudiante> estudiantes ;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "persona")
    @JsonIgnore
    private Set<Usuario> usuarios ;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "persona")
    @JsonIgnore
    private Set<DetallePPP> detallePPPs ;
}
