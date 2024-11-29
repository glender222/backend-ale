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
import pe.edu.upeu.portal.entity.PlanCarrera;
import pe.edu.upeu.portal.service.PlanCarreraService;

@RestController
@RequestMapping("api/plancarrera")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanCarreraController {

    @Autowired
    private PlanCarreraService planCarreraService;

    @GetMapping
    public ResponseEntity<List<PlanCarrera>> readAll() {
        try {
            List<PlanCarrera> planCarreras = planCarreraService.readAll();
            if (planCarreras.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(planCarreras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<PlanCarrera> crear(@Valid @RequestBody PlanCarrera planCarrera) {
        try {
            PlanCarrera pc = planCarreraService.create(planCarrera);
            return new ResponseEntity<>(pc, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanCarrera> getPlanCarreraById(@PathVariable("id") Long id) {
        try {
            Optional<PlanCarrera> pc = planCarreraService.read(id);
            return pc.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delPlanCarrera(@PathVariable("id") Long id) {
        try {
            planCarreraService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanCarrera> updatePlanCarrera(@PathVariable("id") Long id, @Valid @RequestBody PlanCarrera planCarrera) {
        Optional<PlanCarrera> existingPlanCarrera = planCarreraService.read(id);
        if (existingPlanCarrera.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(planCarreraService.update(planCarrera), HttpStatus.OK);
        }
    }
}
