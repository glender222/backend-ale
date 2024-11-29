package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Estado;
import pe.edu.upeu.portal.repository.EstadoRepository;
import pe.edu.upeu.portal.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public Estado create(Estado e) {
        return estadoRepository.save(e);
    }

    @Override
    public Estado update(Estado e) {
        return estadoRepository.save(e);
    }

    @Override
    public Optional<Estado> read(Long id) {
        return estadoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }

    @Override
    public List<Estado> readAll() {
        return estadoRepository.findAll();
    }
}
