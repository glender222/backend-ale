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
import pe.edu.upeu.portal.entity.Proceso;
import pe.edu.upeu.portal.service.ProcesoService;

@RestController
@RequestMapping("api/proceso")
@CrossOrigin(origins = "http://localhost:4200")
public class ProcesoController {

    @Autowired
    private ProcesoService procesoService;

    @GetMapping
    public ResponseEntity<List<Proceso>> readAll() {
        try {
            List<Proceso> procesos = procesoService.readAll();
            if (procesos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(procesos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Proceso> crear(@Valid @RequestBody Proceso proceso) {
        try {
            Proceso p = procesoService.create(proceso);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proceso> getProcesoById(@PathVariable("id") Long id) {
        try {
            Optional<Proceso> p = procesoService.read(id);
            return p.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delProceso(@PathVariable("id") Long id) {
        try {
            procesoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proceso> updateProceso(@PathVariable("id") Long id, @Valid @RequestBody Proceso proceso) {
        Optional<Proceso> existingProceso = procesoService.read(id);
        if (existingProceso.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(procesoService.update(proceso), HttpStatus.OK);
        }
    }
}
