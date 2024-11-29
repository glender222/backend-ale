package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Linea;

public interface LineaService {
    Linea create(Linea l);
    Linea update(Linea l);
    Optional<Linea> read(Long id);
    void delete(Long id);
    List<Linea> readAll();
}
