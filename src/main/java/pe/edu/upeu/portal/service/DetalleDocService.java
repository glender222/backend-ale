package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.DetalleDoc;

public interface DetalleDocService {
    DetalleDoc create(DetalleDoc d);
    DetalleDoc update(DetalleDoc d);
    Optional<DetalleDoc> read(Long id);
    void delete(Long id);
    List<DetalleDoc> readAll();
}
