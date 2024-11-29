package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Empresa;

public interface EmpresaService {
    Empresa create(Empresa e);
    Empresa update(Empresa e);
    Optional<Empresa> read(Long id);
    void delete(Long id);
    List<Empresa> readAll();
}
