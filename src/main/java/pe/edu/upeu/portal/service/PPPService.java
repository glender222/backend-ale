package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.PPP;

public interface PPPService {
    PPP create(PPP p);
    PPP update(PPP p);
    Optional<PPP> read(Long id);
    void delete(Long id);
    List<PPP> readAll();
}
