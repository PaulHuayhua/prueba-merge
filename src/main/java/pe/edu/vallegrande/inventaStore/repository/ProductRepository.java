package pe.edu.vallegrande.inventaStore.repository;

import pe.edu.vallegrande.inventaStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Buscar productos por estado (por ejemplo: 'A' para activo, 'I' para inactivo)
    List<Product> findByState(Character state);
}
