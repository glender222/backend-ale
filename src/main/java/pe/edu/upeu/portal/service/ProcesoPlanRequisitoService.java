package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.ProcesoPlanRequisito;

public interface ProcesoPlanRequisitoService {
    ProcesoPlanRequisito create(ProcesoPlanRequisito p);
    ProcesoPlanRequisito update(ProcesoPlanRequisito p);
    Optional<ProcesoPlanRequisito> read(Long id);
    void delete(Long id);
    List<ProcesoPlanRequisito> readAll();
}
