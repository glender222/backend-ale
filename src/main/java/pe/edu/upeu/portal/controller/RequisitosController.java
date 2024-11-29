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
import pe.edu.upeu.portal.entity.Requisitos;
import pe.edu.upeu.portal.service.RequisitosService;

@RestController
@RequestMapping("api/requisitos")
@CrossOrigin(origins = "http://localhost:4200")
public class RequisitosController {

    @Autowired
    private RequisitosService requisitosService;

    @GetMapping
    public ResponseEntity<List<Requisitos>> readAll() {
        try {
            List<Requisitos> requisitosList = requisitosService.readAll();
            if (requisitosList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(requisitosList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Requisitos> crear(@Valid @RequestBody Requisitos requisitos) {
        try {
            Requisitos r = requisitosService.create(requisitos);
            return new ResponseEntity<>(r, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Requisitos> getRequisitosById(@PathVariable("id") Long id) {
        try {
            Optional<Requisitos> r = requisitosService.read(id);
            return r.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delRequisitos(@PathVariable("id") Long id) {
        try {
            requisitosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Requisitos> updateRequisitos(@PathVariable("id") Long id, @Valid @RequestBody Requisitos requisitos) {
        Optional<Requisitos> existingRequisitos = requisitosService.read(id);
        if (existingRequisitos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(requisitosService.update(requisitos), HttpStatus.OK);
        }
    }
}
