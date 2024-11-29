package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Evaluacion;

public interface EvaluacionService {
    Evaluacion create(Evaluacion e);
    Evaluacion update(Evaluacion e);
    Optional<Evaluacion> read(Long id);
    void delete(Long id);
    List<Evaluacion> readAll();
}
