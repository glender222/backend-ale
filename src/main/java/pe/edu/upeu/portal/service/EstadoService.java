package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Estado;

public interface EstadoService {
    Estado create(Estado e);
    Estado update(Estado e);
    Optional<Estado> read(Long id);
    void delete(Long id);
    List<Estado> readAll();
}
