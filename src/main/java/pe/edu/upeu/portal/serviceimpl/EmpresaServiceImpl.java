package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Empresa;
import pe.edu.upeu.portal.repository.EmpresaRepository;
import pe.edu.upeu.portal.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa create(Empresa e) {
        return empresaRepository.save(e);
    }

    @Override
    public Empresa update(Empresa e) {
        return empresaRepository.save(e);
    }

    @Override
    public Optional<Empresa> read(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public List<Empresa> readAll() {
        return empresaRepository.findAll();
    }
}
