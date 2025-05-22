package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.BuysDetail;

import java.util.List;
import java.util.Optional;

public interface BuysDetailService {

    List<BuysDetail> findAll();

    Optional<BuysDetail> findById(Long identifier);

    BuysDetail save(BuysDetail buysDetail);

    // Puedes agregar update o delete si en el futuro los necesitas
}
