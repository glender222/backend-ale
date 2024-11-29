package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Rubro;

public interface RubroService {
    Rubro create(Rubro r);
    Rubro update(Rubro r);
    Optional<Rubro> read(Long id);
    void delete(Long id);
    List<Rubro> readAll();
}
