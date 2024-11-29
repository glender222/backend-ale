package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Estudiante;

public interface EstudianteService {
    Estudiante create(Estudiante e);
    Estudiante update(Estudiante e);
    Optional<Estudiante> read(Long id);
    void delete(Long id);
    List<Estudiante> readAll();
}
