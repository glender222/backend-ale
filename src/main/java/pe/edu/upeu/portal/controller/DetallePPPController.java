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
import pe.edu.upeu.portal.entity.DetallePPP;
import pe.edu.upeu.portal.service.DetallePPPService;

@RestController
@RequestMapping("api/detalleppp")
@CrossOrigin(origins = "http://localhost:4200")
public class DetallePPPController {

    @Autowired
    private DetallePPPService detallePPPService;

    @GetMapping
    public ResponseEntity<List<DetallePPP>> readAll() {
        try {
            List<DetallePPP> detalles = detallePPPService.readAll();
            if (detalles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(detalles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<DetallePPP> crear(@Valid @RequestBody DetallePPP detalle) {
        try {
            DetallePPP d = detallePPPService.create(detalle);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePPP> getDetallePPPById(@PathVariable("id") Long id) {
        try {
            Optional<DetallePPP> d = detallePPPService.read(id);
            return d.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delDetallePPP(@PathVariable("id") Long id) {
        try {
            detallePPPService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePPP> updateDetallePPP(@PathVariable("id") Long id, @Valid @RequestBody DetallePPP detalle) {
        Optional<DetallePPP> existingDetalle = detallePPPService.read(id);
        if (existingDetalle.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(detallePPPService.update(detalle), HttpStatus.OK);
        }
    }
}
