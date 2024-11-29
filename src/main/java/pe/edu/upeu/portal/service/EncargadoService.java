package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Encargado;

public interface EncargadoService {
    Encargado create(Encargado e);
    Encargado update(Encargado e);
    Optional<Encargado> read(Long id);
    void delete(Long id);
    List<Encargado> readAll();
}
