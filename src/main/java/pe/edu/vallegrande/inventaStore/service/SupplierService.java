package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.Supplier;
import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<Supplier> findAll();

    Optional<Supplier> findById(Long id);

    List<Supplier> findByState(String state);

    Supplier save(Supplier supplier);

    Supplier update(Supplier supplier);

    Optional<Supplier> softDelete(Long id);
    
    Optional<Supplier> restore(Long id);
}