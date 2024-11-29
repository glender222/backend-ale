package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Plan;

public interface PlanService {
    Plan create(Plan p);
    Plan update(Plan p);
    Optional<Plan> read(Long id);
    void delete(Long id);
    List<Plan> readAll();
}
