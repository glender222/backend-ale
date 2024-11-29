package pe.edu.upeu.portal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.edu.upeu.portal.entity.UsuarioRol;
import pe.edu.upeu.portal.service.UsuarioRolService;

@RestController
@RequestMapping("api/usuariorol")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioRolController {

    @Autowired
    private UsuarioRolService usuarioRolService;

    @GetMapping
    public ResponseEntity<List<UsuarioRol>> readAll() {
        try {
            List<UsuarioRol> usuarioRoles = usuarioRolService.readAll();
            if (usuarioRoles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(usuarioRoles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioRol> crear(@Valid @RequestBody UsuarioRol usuarioRol) {
        try {
            UsuarioRol ur = usuarioRolService.create(usuarioRol);
            return new ResponseEntity<>(ur, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRol> getUsuarioRolById(@PathVariable("id") Long id) {
        try {
            Optional<UsuarioRol> ur = usuarioRolService.read(id);
            return ur.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delUsuarioRol(@PathVariable("id") Long id) {
        try {
            usuarioRolService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioRol> updateUsuarioRol(@PathVariable("id") Long id, @Valid @RequestBody UsuarioRol usuarioRol) {
        Optional<UsuarioRol> existingUsuarioRol = usuarioRolService.read(id);
        if (existingUsuarioRol.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usuarioRolService.update(usuarioRol), HttpStatus.OK);
        }
    }
}
