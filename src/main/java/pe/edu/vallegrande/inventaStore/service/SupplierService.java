package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.Supplier;
import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<Supplier> findAll();

    Optional<Supplier> findById(Long id);

    Supplier save(Supplier supplier);

    Supplier update(Supplier supplier);

    Supplier delete(Supplier supplier);
    
}