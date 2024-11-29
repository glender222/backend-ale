package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Carrera;
import pe.edu.upeu.portal.repository.CarreraRepository;
import pe.edu.upeu.portal.service.CarreraService;

@Service
public class CarreraServiceImpl implements CarreraService{
	
	@Autowired
	private CarreraRepository carreraRepository;

	@Override
	public Carrera create(Carrera c) {
		// TODO Auto-generated method stub
		return carreraRepository.save(c);
	}

	@Override
	public Carrera update(Carrera c) {
		// TODO Auto-generated method stub
		return carreraRepository.save(c);
	}

	@Override
	public Optional<Carrera> read(Long id) {
		// TODO Auto-generated method stub
		return carreraRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		carreraRepository.deleteById(id);
	}

	@Override
	public List<Carrera> readAll() {
		// TODO Auto-generated method stub
		return carreraRepository.findAll();
	}

}
