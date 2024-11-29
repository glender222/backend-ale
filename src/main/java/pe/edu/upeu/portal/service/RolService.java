package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Rol;

public interface RolService {
    Rol create(Rol r);
    Rol update(Rol r);
    Optional<Rol> read(Long id);
    void delete(Long id);
    List<Rol> readAll();
}
