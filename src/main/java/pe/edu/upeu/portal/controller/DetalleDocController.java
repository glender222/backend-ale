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
import pe.edu.upeu.portal.entity.DetalleDoc;
import pe.edu.upeu.portal.service.DetalleDocService;

@RestController
@RequestMapping("api/detalledoc")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleDocController {

    @Autowired
    private DetalleDocService detalleDocService;

    @GetMapping
    public ResponseEntity<List<DetalleDoc>> readAll() {
        try {
            List<DetalleDoc> detalles = detalleDocService.readAll();
            if (detalles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(detalles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<DetalleDoc> crear(@Valid @RequestBody DetalleDoc detalle) {
        try {
            DetalleDoc d = detalleDocService.create(detalle);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleDoc> getDetalleDocById(@PathVariable("id") Long id) {
        try {
            Optional<DetalleDoc> d = detalleDocService.read(id);
            return d.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delDetalleDoc(@PathVariable("id") Long id) {
        try {
            detalleDocService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleDoc> updateDetalleDoc(@PathVariable("id") Long id, @Valid @RequestBody DetalleDoc detalle) {
        Optional<DetalleDoc> existingDetalle = detalleDocService.read(id);
        if (existingDetalle.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(detalleDocService.update(detalle), HttpStatus.OK);
        }
    }
}
