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
import pe.edu.upeu.portal.entity.Privilegios;
import pe.edu.upeu.portal.service.PrivilegiosService;

@RestController
@RequestMapping("api/privilegios")
@CrossOrigin(origins = "http://localhost:4200")
public class PrivilegiosController {

    @Autowired
    private PrivilegiosService privilegiosService;

    @GetMapping
    public ResponseEntity<List<Privilegios>> readAll() {
        try {
            List<Privilegios> privilegios = privilegiosService.readAll();
            if (privilegios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(privilegios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Privilegios> crear(@Valid @RequestBody Privilegios privilegios) {
        try {
            Privilegios p = privilegiosService.create(privilegios);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Privilegios> getPrivilegiosById(@PathVariable("id") Long id) {
        try {
            Optional<Privilegios> p = privilegiosService.read(id);
            return p.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delPrivilegios(@PathVariable("id") Long id) {
        try {
            privilegiosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Privilegios> updatePrivilegios(@PathVariable("id") Long id, @Valid @RequestBody Privilegios privilegios) {
        Optional<Privilegios> existingPrivilegios = privilegiosService.read(id);
        if (existingPrivilegios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(privilegiosService.update(privilegios), HttpStatus.OK);
        }
    }
}
