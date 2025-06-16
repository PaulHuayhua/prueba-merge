package pe.edu.vallegrande.inventaStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.vallegrande.inventaStore.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByState(Boolean state);

    List<Product> findByNameContainingIgnoreCase(String name);

    Long countByState(Boolean state);

    @Query("SELECT p FROM Product p WHERE p.stock <= 5 AND p.state = true")
    List<Product> findLowStockProducts();

    @Query(value = """
                SELECT * FROM product
                WHERE expiration_date IS NOT NULL
                AND expiration_date <= DATEADD(DAY, 7, CAST(GETDATE() AS DATE))
            """, nativeQuery = true)
    List<Product> findExpiringSoonProducts();

}
