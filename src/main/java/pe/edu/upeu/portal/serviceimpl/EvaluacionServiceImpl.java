package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Evaluacion;
import pe.edu.upeu.portal.repository.EvaluacionRepository;
import pe.edu.upeu.portal.service.EvaluacionService;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Override
    public Evaluacion create(Evaluacion e) {
        return evaluacionRepository.save(e);
    }

    @Override
    public Evaluacion update(Evaluacion e) {
        return evaluacionRepository.save(e);
    }

    @Override
    public Optional<Evaluacion> read(Long id) {
        return evaluacionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        evaluacionRepository.deleteById(id);
    }

    @Override
    public List<Evaluacion> readAll() {
        return evaluacionRepository.findAll();
    }
}
