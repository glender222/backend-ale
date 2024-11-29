package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Privilegios;
import pe.edu.upeu.portal.repository.PrivilegiosRepository;
import pe.edu.upeu.portal.service.PrivilegiosService;

@Service
public class PrivilegiosServiceImpl implements PrivilegiosService {

    @Autowired
    private PrivilegiosRepository privilegiosRepository;

    @Override
    public Privilegios create(Privilegios p) {
        return privilegiosRepository.save(p);
    }

    @Override
    public Privilegios update(Privilegios p) {
        return privilegiosRepository.save(p);
    }

    @Override
    public Optional<Privilegios> read(Long id) {
        return privilegiosRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        privilegiosRepository.deleteById(id);
    }

    @Override
    public List<Privilegios> readAll() {
        return privilegiosRepository.findAll();
    }
}
