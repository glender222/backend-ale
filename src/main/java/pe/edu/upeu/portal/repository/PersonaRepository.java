package pe.edu.upeu.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.portal.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
