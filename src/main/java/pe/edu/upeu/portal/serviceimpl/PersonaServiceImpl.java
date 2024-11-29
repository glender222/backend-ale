package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Persona;
import pe.edu.upeu.portal.repository.PersonaRepository;
import pe.edu.upeu.portal.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona create(Persona p) {
        return personaRepository.save(p);
    }

    @Override
    public Persona update(Persona p) {
        return personaRepository.save(p);
    }

    @Override
    public Optional<Persona> read(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public List<Persona> readAll() {
        return personaRepository.findAll();
    }
}
