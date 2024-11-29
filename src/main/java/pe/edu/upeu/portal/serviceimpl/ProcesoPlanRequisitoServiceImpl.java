package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.ProcesoPlanRequisito;
import pe.edu.upeu.portal.repository.ProcesoPlanRequisitoRepository;
import pe.edu.upeu.portal.service.ProcesoPlanRequisitoService;

@Service
public class ProcesoPlanRequisitoServiceImpl implements ProcesoPlanRequisitoService {

    @Autowired
    private ProcesoPlanRequisitoRepository procesoPlanRequisitoRepository;

    @Override
    public ProcesoPlanRequisito create(ProcesoPlanRequisito p) {
        return procesoPlanRequisitoRepository.save(p);
    }

    @Override
    public ProcesoPlanRequisito update(ProcesoPlanRequisito p) {
        return procesoPlanRequisitoRepository.save(p);
    }

    @Override
    public Optional<ProcesoPlanRequisito> read(Long id) {
        return procesoPlanRequisitoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        procesoPlanRequisitoRepository.deleteById(id);
    }

    @Override
    public List<ProcesoPlanRequisito> readAll() {
        return procesoPlanRequisitoRepository.findAll();
    }
}
