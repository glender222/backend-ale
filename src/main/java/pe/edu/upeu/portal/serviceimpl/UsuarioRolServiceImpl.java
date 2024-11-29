package pe.edu.upeu.portal.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.portal.entity.UsuarioRol;
import pe.edu.upeu.portal.repository.UsuarioRolRepository;
import pe.edu.upeu.portal.service.UsuarioRolService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    public UsuarioRol create(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }

    @Override
    public UsuarioRol update(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }

    @Override
    public void delete(Long id) {
        usuarioRolRepository.deleteById(id);
    }

	@Override
	public Optional<UsuarioRol> read(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<UsuarioRol> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
