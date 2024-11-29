package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Proceso;

public interface ProcesoService {
    Proceso create(Proceso p);
    Proceso update(Proceso p);
    Optional<Proceso> read(Long id);
    void delete(Long id);
    List<Proceso> readAll();
}
