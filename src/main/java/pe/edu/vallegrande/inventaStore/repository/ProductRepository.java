package pe.edu.vallegrande.inventaStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.inventaStore.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByState(Boolean state);

    List<Product> findByNameContainingIgnoreCase(String name);

}
