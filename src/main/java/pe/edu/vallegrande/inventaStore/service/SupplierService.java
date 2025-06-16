package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.Supplier;
import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<Supplier> findAll();

    Optional<Supplier> findById(Long identifier);

    List<Supplier> findByState(Boolean state);

    Supplier save(Supplier supplier);

    Supplier update(Supplier supplier);

    Optional<Supplier> softDelete(Long identifier);
    
    Optional<Supplier> restore(Long identifier);

    Long getCount();
}