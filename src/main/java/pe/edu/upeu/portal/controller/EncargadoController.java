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
import pe.edu.upeu.portal.entity.Encargado;
import pe.edu.upeu.portal.service.EncargadoService;

@RestController
@RequestMapping("api/encargado")
@CrossOrigin(origins = "http://localhost:4200")
public class EncargadoController {

    @Autowired
    private EncargadoService encargadoService;

    @GetMapping
    public ResponseEntity<List<Encargado>> readAll() {
        try {
            List<Encargado> encargados = encargadoService.readAll();
            if (encargados.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(encargados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Encargado> crear(@Valid @RequestBody Encargado encargado) {
        try {
            Encargado e = encargadoService.create(encargado);
            return new ResponseEntity<>(e, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encargado> getEncargadoById(@PathVariable("id") Long id) {
        try {
            Optional<Encargado> e = encargadoService.read(id);
            return e.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delEncargado(@PathVariable("id") Long id) {
        try {
            encargadoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Encargado> updateEncargado(@PathVariable("id") Long id, @Valid @RequestBody Encargado encargado) {
        Optional<Encargado> existingEncargado = encargadoService.read(id);
        if (existingEncargado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(encargadoService.update(encargado), HttpStatus.OK);
        }
    }
}
