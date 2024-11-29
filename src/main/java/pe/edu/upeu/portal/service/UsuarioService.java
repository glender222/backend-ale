package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Usuario;

public interface UsuarioService {
    Usuario create(Usuario u);
    Usuario update(Usuario u);
    Optional<Usuario> read(Long id);
    void delete(Long id);
    List<Usuario> readAll();
}
