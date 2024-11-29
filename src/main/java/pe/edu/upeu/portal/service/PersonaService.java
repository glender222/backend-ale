package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Persona;

public interface PersonaService {
    Persona create(Persona p);
    Persona update(Persona p);
    Optional<Persona> read(Long id);
    void delete(Long id);
    List<Persona> readAll();
}
