package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.PlanCarrera;
import pe.edu.upeu.portal.repository.PlanCarreraRepository;
import pe.edu.upeu.portal.service.PlanCarreraService;

@Service
public class PlanCarreraServiceImpl implements PlanCarreraService {

    @Autowired
    private PlanCarreraRepository planCarreraRepository;

    @Override
    public PlanCarrera create(PlanCarrera p) {
        return planCarreraRepository.save(p);
    }

    @Override
    public PlanCarrera update(PlanCarrera p) {
        return planCarreraRepository.save(p);
    }

    @Override
    public Optional<PlanCarrera> read(Long id) {
        return planCarreraRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        planCarreraRepository.deleteById(id);
    }

    @Override
    public List<PlanCarrera> readAll() {
        return planCarreraRepository.findAll();
    }
}
