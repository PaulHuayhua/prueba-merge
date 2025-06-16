package pe.edu.vallegrande.inventaStore.repository;

import pe.edu.vallegrande.inventaStore.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByState(Boolean state);
}