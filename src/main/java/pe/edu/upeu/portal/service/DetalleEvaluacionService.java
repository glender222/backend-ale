package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.DetalleEvaluacion;

public interface DetalleEvaluacionService {
    DetalleEvaluacion create(DetalleEvaluacion d);
    DetalleEvaluacion update(DetalleEvaluacion d);
    Optional<DetalleEvaluacion> read(Long id);
    void delete(Long id);
    List<DetalleEvaluacion> readAll();
}
