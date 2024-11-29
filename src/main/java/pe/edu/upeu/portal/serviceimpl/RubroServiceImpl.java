package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Rubro;
import pe.edu.upeu.portal.repository.RubroRepository;
import pe.edu.upeu.portal.service.RubroService;

@Service
public class RubroServiceImpl implements RubroService {

    @Autowired
    private RubroRepository rubroRepository;

    @Override
    public Rubro create(Rubro r) {
        return rubroRepository.save(r);
    }

    @Override
    public Rubro update(Rubro r) {
        return rubroRepository.save(r);
    }

    @Override
    public Optional<Rubro> read(Long id) {
        return rubroRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        rubroRepository.deleteById(id);
    }

    @Override
    public List<Rubro> readAll() {
        return rubroRepository.findAll();
    }
}
