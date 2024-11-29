package pe.edu.upeu.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.portal.entity.UsuarioRol;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long>{
	Optional<UsuarioRol> findById(Long idusuarioRol);
}
