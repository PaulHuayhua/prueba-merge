package pe.edu.vallegrande.inventaStore.service.impl;


import pe.edu.vallegrande.inventaStore.model.Product;
import pe.edu.vallegrande.inventaStore.repository.ProductRepository;
import pe.edu.vallegrande.inventaStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> findAll() {
        log.info("Listando productos...");
        return productRepository.findAll();
    }


    @Override
    public Optional<Product> findById(Long id) {
        log.info("Buscando producto por ID: " + id);
        return productRepository.findById(id);
    }
    
    @Override
    public List<Product> findByState(Character state) {
        log.info("Buscando producto por estado: " + state);
        return productRepository.findByState(state);
    }

    @Override
    public Product save(Product product) {
        log.info("Guardando producto: " + product.toString());
        return productRepository.save(product);
    }
    
    @Override
    public Product update(Product product) {
        log.info("Actualizando producto: " + product.toString());
        return productRepository.save(product);
    }

    @Override
    public Product deleteById(Long id) {
        log.info("Eliminando producto con ID: " + id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto con ID " + id + " no encontrado"));
        product.setState('I'); // Cambiar el estado a 'Inactivo'
        return productRepository.save(product);
    }
    
    @Override
public Product restoreById(Long id) {
    log.info("Restaurando producto con ID: " + id);
    Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    product.setState('A'); // Restaurar el estado a 'A' (Activo)
    return productRepository.save(product);
}
}
