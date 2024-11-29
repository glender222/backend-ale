package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Requisitos;

public interface RequisitosService {
    Requisitos create(Requisitos r);
    Requisitos update(Requisitos r);
    Optional<Requisitos> read(Long id);
    void delete(Long id);
    List<Requisitos> readAll();
}
