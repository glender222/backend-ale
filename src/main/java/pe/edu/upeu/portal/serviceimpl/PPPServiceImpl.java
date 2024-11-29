package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.PPP;
import pe.edu.upeu.portal.repository.PPPRepository;
import pe.edu.upeu.portal.service.PPPService;

@Service
public class PPPServiceImpl implements PPPService {

    @Autowired
    private PPPRepository pppRepository;

    @Override
    public PPP create(PPP p) {
        return pppRepository.save(p);
    }

    @Override
    public PPP update(PPP p) {
        return pppRepository.save(p);
    }

    @Override
    public Optional<PPP> read(Long id) {
        return pppRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        pppRepository.deleteById(id);
    }

    @Override
    public List<PPP> readAll() {
        return pppRepository.findAll();
    }
}
