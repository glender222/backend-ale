package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Proceso;
import pe.edu.upeu.portal.repository.ProcesoRepository;
import pe.edu.upeu.portal.service.ProcesoService;

@Service
public class ProcesoServiceImpl implements ProcesoService {

    @Autowired
    private ProcesoRepository procesoRepository;

    @Override
    public Proceso create(Proceso p) {
        return procesoRepository.save(p);
    }

    @Override
    public Proceso update(Proceso p) {
        return procesoRepository.save(p);
    }

    @Override
    public Optional<Proceso> read(Long id) {
        return procesoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        procesoRepository.deleteById(id);
    }

    @Override
    public List<Proceso> readAll() {
        return procesoRepository.findAll();
    }
}
