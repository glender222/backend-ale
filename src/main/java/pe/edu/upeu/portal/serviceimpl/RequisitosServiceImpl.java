package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Requisitos;
import pe.edu.upeu.portal.repository.RequisitosRepository;
import pe.edu.upeu.portal.service.RequisitosService;

@Service
public class RequisitosServiceImpl implements RequisitosService {

    @Autowired
    private RequisitosRepository requisitosRepository;

    @Override
    public Requisitos create(Requisitos r) {
        return requisitosRepository.save(r);
    }

    @Override
    public Requisitos update(Requisitos r) {
        return requisitosRepository.save(r);
    }

    @Override
    public Optional<Requisitos> read(Long id) {
        return requisitosRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        requisitosRepository.deleteById(id);
    }

    @Override
    public List<Requisitos> readAll() {
        return requisitosRepository.findAll();
    }
}
