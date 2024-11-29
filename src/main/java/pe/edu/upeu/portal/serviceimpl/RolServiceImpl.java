package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Rol;
import pe.edu.upeu.portal.repository.RolRepository;
import pe.edu.upeu.portal.service.RolService;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Rol create(Rol r) {
        return rolRepository.save(r);
    }

    @Override
    public Rol update(Rol r) {
        return rolRepository.save(r);
    }

    @Override
    public Optional<Rol> read(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public List<Rol> readAll() {
        return rolRepository.findAll();
    }
}
