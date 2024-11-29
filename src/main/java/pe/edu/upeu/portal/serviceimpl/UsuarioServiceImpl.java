package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Usuario;
import pe.edu.upeu.portal.repository.UsuarioRepository;
import pe.edu.upeu.portal.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public Usuario update(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public Optional<Usuario> read(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> readAll() {
        return usuarioRepository.findAll();
    }
}
