package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Plan;
import pe.edu.upeu.portal.repository.PlanRepository;
import pe.edu.upeu.portal.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public Plan create(Plan p) {
        return planRepository.save(p);
    }

    @Override
    public Plan update(Plan p) {
        return planRepository.save(p);
    }

    @Override
    public Optional<Plan> read(Long id) {
        return planRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public List<Plan> readAll() {
        return planRepository.findAll();
    }
}
