package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Carrera;

public interface CarreraService {
	Carrera create(Carrera c);
	Carrera update(Carrera c);
	Optional<Carrera> read(Long id);
	void delete(Long id);
	List<Carrera> readAll();
}
