package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Linea;
import pe.edu.upeu.portal.repository.LineaRepository;
import pe.edu.upeu.portal.service.LineaService;

@Service
public class LineaServiceImpl implements LineaService {

    @Autowired
    private LineaRepository lineaRepository;

    @Override
    public Linea create(Linea l) {
        return lineaRepository.save(l);
    }

    @Override
    public Linea update(Linea l) {
        return lineaRepository.save(l);
    }

    @Override
    public Optional<Linea> read(Long id) {
        return lineaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        lineaRepository.deleteById(id);
    }

    @Override
    public List<Linea> readAll() {
        return lineaRepository.findAll();
    }
}
