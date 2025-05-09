package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findByState(String state);

    Product save(Product product);

    Product update(Product product);

    Product deleteById(Long id);

    Product restoreById(Long id);
}
