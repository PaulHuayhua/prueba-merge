package pe.edu.vallegrande.inventaStore.repository;


import pe.edu.vallegrande.inventaStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
   
}
