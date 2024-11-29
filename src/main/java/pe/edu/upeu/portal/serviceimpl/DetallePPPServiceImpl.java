package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.DetallePPP;
import pe.edu.upeu.portal.repository.DetallePPPRepository;
import pe.edu.upeu.portal.service.DetallePPPService;

@Service
public class DetallePPPServiceImpl implements DetallePPPService {

    @Autowired
    private DetallePPPRepository detallePPPRepository;

    @Override
    public DetallePPP create(DetallePPP d) {
        return detallePPPRepository.save(d);
    }

    @Override
    public DetallePPP update(DetallePPP d) {
        return detallePPPRepository.save(d);
    }

    @Override
    public Optional<DetallePPP> read(Long id) {
        return detallePPPRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        detallePPPRepository.deleteById(id);
    }

    @Override
    public List<DetallePPP> readAll() {
        return detallePPPRepository.findAll();
    }
}
