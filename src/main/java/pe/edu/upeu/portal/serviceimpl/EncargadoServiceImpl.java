package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Encargado;
import pe.edu.upeu.portal.repository.EncargadoRepository;
import pe.edu.upeu.portal.service.EncargadoService;

@Service
public class EncargadoServiceImpl implements EncargadoService {

    @Autowired
    private EncargadoRepository encargadoRepository;

    @Override
    public Encargado create(Encargado e) {
        return encargadoRepository.save(e);
    }

    @Override
    public Encargado update(Encargado e) {
        return encargadoRepository.save(e);
    }

    @Override
    public Optional<Encargado> read(Long id) {
        return encargadoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        encargadoRepository.deleteById(id);
    }

    @Override
    public List<Encargado> readAll() {
        return encargadoRepository.findAll();
    }
}
