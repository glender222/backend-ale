package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.DetalleDoc;
import pe.edu.upeu.portal.repository.DetalleDocRepository;
import pe.edu.upeu.portal.service.DetalleDocService;

@Service
public class DetalleDocServiceImpl implements DetalleDocService {

    @Autowired
    private DetalleDocRepository detalleDocRepository;

    @Override
    public DetalleDoc create(DetalleDoc d) {
        return detalleDocRepository.save(d);
    }

    @Override
    public DetalleDoc update(DetalleDoc d) {
        return detalleDocRepository.save(d);
    }

    @Override
    public Optional<DetalleDoc> read(Long id) {
        return detalleDocRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        detalleDocRepository.deleteById(id);
    }

    @Override
    public List<DetalleDoc> readAll() {
        return detalleDocRepository.findAll();
    }
}
