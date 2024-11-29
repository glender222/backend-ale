package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Matricula;
import pe.edu.upeu.portal.repository.MatriculaRepository;
import pe.edu.upeu.portal.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public Matricula create(Matricula m) {
        return matriculaRepository.save(m);
    }

    @Override
    public Matricula update(Matricula m) {
        return matriculaRepository.save(m);
    }

    @Override
    public Optional<Matricula> read(Long id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }

    @Override
    public List<Matricula> readAll() {
        return matriculaRepository.findAll();
    }
}
