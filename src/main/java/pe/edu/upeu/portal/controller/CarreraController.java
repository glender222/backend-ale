package pe.edu.upeu.portal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.portal.jakarta.validation.Valid;
import pe.edu.upeu.portal.entity.Carrera;
import pe.edu.upeu.portal.service.CarreraService;

@RestController
@RequestMapping("api/carrera")
@CrossOrigin(origins = "http://localhost:4200")
public class CarreraController {
	@Autowired
	private CarreraService carreraService;
	
	@GetMapping
    public ResponseEntity<List<Carrera>> readAll() {
        try {
            List<Carrera> carreras = carreraService.readAll();
            if (carreras.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(carreras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PostMapping
    public ResponseEntity<Carrera> crear(@Valid @RequestBody Carrera alumnos) {
        try {
        	Carrera c = carreraService.create(alumnos);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable("id") Long id) {
        try {
            Optional<Carrera> c = carreraService.read(id);
            return c.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delCarrera(@PathVariable("id") Long id) {
        try {
            carreraService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Carrera> updateCarrera(@PathVariable("id") Long id, @Valid @RequestBody Carrera carrera) {
        Optional<Carrera> existingCarrera = carreraService.read(id);
        if (existingCarrera.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(carreraService.update(carrera), HttpStatus.OK);
        }
    }
}
