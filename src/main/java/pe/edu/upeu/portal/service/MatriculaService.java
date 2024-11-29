package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Matricula;

public interface MatriculaService {
    Matricula create(Matricula m);
    Matricula update(Matricula m);
    Optional<Matricula> read(Long id);
    void delete(Long id);
    List<Matricula> readAll();
}
