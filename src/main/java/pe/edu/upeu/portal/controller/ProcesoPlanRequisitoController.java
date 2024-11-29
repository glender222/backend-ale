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
import pe.edu.upeu.portal.entity.ProcesoPlanRequisito;
import pe.edu.upeu.portal.service.ProcesoPlanRequisitoService;

@RestController
@RequestMapping("api/procesoPlanRequisito")
@CrossOrigin(origins = "http://localhost:4200")
public class ProcesoPlanRequisitoController {

    @Autowired
    private ProcesoPlanRequisitoService procesoPlanRequisitoService;

    @GetMapping
    public ResponseEntity<List<ProcesoPlanRequisito>> readAll() {
        try {
            List<ProcesoPlanRequisito> procesoPlanRequisitos = procesoPlanRequisitoService.readAll();
            if (procesoPlanRequisitos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(procesoPlanRequisitos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<ProcesoPlanRequisito> crear(@Valid @RequestBody ProcesoPlanRequisito procesoPlanRequisito) {
        try {
            ProcesoPlanRequisito p = procesoPlanRequisitoService.create(procesoPlanRequisito);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcesoPlanRequisito> getProcesoPlanRequisitoById(@PathVariable("id") Long id) {
        try {
            Optional<ProcesoPlanRequisito> p = procesoPlanRequisitoService.read(id);
            return p.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delProcesoPlanRequisito(@PathVariable("id") Long id) {
        try {
            procesoPlanRequisitoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcesoPlanRequisito> updateProcesoPlanRequisito(@PathVariable("id") Long id, @Valid @RequestBody ProcesoPlanRequisito procesoPlanRequisito) {
        Optional<ProcesoPlanRequisito> existingProcesoPlanRequisito = procesoPlanRequisitoService.read(id);
        if (existingProcesoPlanRequisito.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(procesoPlanRequisitoService.update(procesoPlanRequisito), HttpStatus.OK);
        }
    }
}
