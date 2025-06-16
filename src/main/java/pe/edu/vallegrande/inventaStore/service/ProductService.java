package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findByState(Boolean state);

    List<Product> searchByName(String name);  

    Product save(Product product);

    Product update(Long id, Product product);

    Product deleteById(Long id);

    Product restoreById(Long id);

    Long getActiveCount();

}
