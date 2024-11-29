package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Estudiante;
import pe.edu.upeu.portal.repository.EstudianteRepository;
import pe.edu.upeu.portal.service.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Estudiante create(Estudiante e) {
        return estudianteRepository.save(e);
    }

    @Override
    public Estudiante update(Estudiante e) {
        return estudianteRepository.save(e);
    }

    @Override
    public Optional<Estudiante> read(Long id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public List<Estudiante> readAll() {
        return estudianteRepository.findAll();
    }
}
