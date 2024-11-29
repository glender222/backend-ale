package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Privilegios;

public interface PrivilegiosService {
    Privilegios create(Privilegios p);
    Privilegios update(Privilegios p);
    Optional<Privilegios> read(Long id);
    void delete(Long id);
    List<Privilegios> readAll();
}
