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
    public List<Product> findByState(Boolean state) {
        return productRepo.findByState(state);
    }

    @Override
    public Product save(Product product) {
        product.setState(true);
        return productRepo.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<Product> existingOpt = productRepo.findById(id);
        if (existingOpt.isEmpty()) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }

        Product existing = existingOpt.get();
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setSize(product.getSize());
        existing.setStock(product.getStock());
        existing.setPrice(product.getPrice());
        existing.setExpiration_date(product.getExpiration_date());
        existing.setCategory(product.getCategory());
        existing.setState(product.getState());

        return productRepo.save(existing);
    }

    @Override
    public Product deleteById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        product.setState(false);
        return productRepo.save(product);
    }

    @Override
    public Product restoreById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        product.setState(true);
        return productRepo.save(product);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Long getActiveCount() {
        return productRepo.countByState(true);
    }

}
