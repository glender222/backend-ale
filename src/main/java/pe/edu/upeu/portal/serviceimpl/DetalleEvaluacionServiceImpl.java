package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.DetalleEvaluacion;
import pe.edu.upeu.portal.repository.DetalleEvaluacionRepository;
import pe.edu.upeu.portal.service.DetalleEvaluacionService;

@Service
public class DetalleEvaluacionServiceImpl implements DetalleEvaluacionService {

    @Autowired
    private DetalleEvaluacionRepository detalleEvaluacionRepository;

    @Override
    public DetalleEvaluacion create(DetalleEvaluacion d) {
        return detalleEvaluacionRepository.save(d);
    }

    @Override
    public DetalleEvaluacion update(DetalleEvaluacion d) {
        return detalleEvaluacionRepository.save(d);
    }

    @Override
    public Optional<DetalleEvaluacion> read(Long id) {
        return detalleEvaluacionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        detalleEvaluacionRepository.deleteById(id);
    }

    @Override
    public List<DetalleEvaluacion> readAll() {
        return detalleEvaluacionRepository.findAll();
    }
}
