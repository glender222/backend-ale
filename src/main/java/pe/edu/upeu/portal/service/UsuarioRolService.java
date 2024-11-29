package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.UsuarioRol;

public interface UsuarioRolService {
	UsuarioRol create(UsuarioRol u);
	UsuarioRol update(UsuarioRol u);
	Optional<UsuarioRol> read(Long id);
    void delete(Long id);
    List<UsuarioRol> readAll();
}
