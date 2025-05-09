package pe.edu.vallegrande.inventaStore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.inventaStore.model.Product;
import pe.edu.vallegrande.inventaStore.repository.ProductRepository;
import pe.edu.vallegrande.inventaStore.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public List<Product> findByState(String state) {
        return productRepo.findByState(state);
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        if (!productRepo.existsById(product.getIdentifier())) {
            throw new RuntimeException("Producto no encontrado con ID: " + product.getIdentifier());
        }
        return productRepo.save(product);
    }

    @Override
    public Product deleteById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        product.setState("I");
        return productRepo.save(product);
    }

    @Override
    public Product restoreById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        product.setState("A");
        return productRepo.save(product);
    }
}
