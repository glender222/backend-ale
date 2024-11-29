package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.PlanCarrera;

public interface PlanCarreraService {
    PlanCarrera create(PlanCarrera p);
    PlanCarrera update(PlanCarrera p);
    Optional<PlanCarrera> read(Long id);
    void delete(Long id);
    List<PlanCarrera> readAll();
}
