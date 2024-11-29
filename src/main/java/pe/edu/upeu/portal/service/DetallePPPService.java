package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.DetallePPP;

public interface DetallePPPService {
    DetallePPP create(DetallePPP d);
    DetallePPP update(DetallePPP d);
    Optional<DetallePPP> read(Long id);
    void delete(Long id);
    List<DetallePPP> readAll();
}
