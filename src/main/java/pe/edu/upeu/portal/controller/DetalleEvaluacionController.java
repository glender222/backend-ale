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
import pe.edu.upeu.portal.entity.DetalleEvaluacion;
import pe.edu.upeu.portal.service.DetalleEvaluacionService;

@RestController
@RequestMapping("api/detalleevaluacion")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleEvaluacionController {

    @Autowired
    private DetalleEvaluacionService detalleEvaluacionService;

    @GetMapping
    public ResponseEntity<List<DetalleEvaluacion>> readAll() {
        try {
            List<DetalleEvaluacion> detalles = detalleEvaluacionService.readAll();
            if (detalles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(detalles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<DetalleEvaluacion> crear(@Valid @RequestBody DetalleEvaluacion detalle) {
        try {
            DetalleEvaluacion d = detalleEvaluacionService.create(detalle);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleEvaluacion> getDetalleEvaluacionById(@PathVariable("id") Long id) {
        try {
            Optional<DetalleEvaluacion> d = detalleEvaluacionService.read(id);
            return d.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delDetalleEvaluacion(@PathVariable("id") Long id) {
        try {
            detalleEvaluacionService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleEvaluacion> updateDetalleEvaluacion(@PathVariable("id") Long id, @Valid @RequestBody DetalleEvaluacion detalle) {
        Optional<DetalleEvaluacion> existingDetalle = detalleEvaluacionService.read(id);
        if (existingDetalle.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(detalleEvaluacionService.update(detalle), HttpStatus.OK);
        }
    }
}
