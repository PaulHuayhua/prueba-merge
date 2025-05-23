package pe.edu.vallegrande.inventaStore.rest;

import pe.edu.vallegrande.inventaStore.model.Product;
import pe.edu.vallegrande.inventaStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/product")
public class ProductRest {

    private final ProductService productService;

    @Autowired
    public ProductRest(ProductService productService) {
        this.productService = productService;
    }

    // ✅ Obtener todos los productos
    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    // ✅ Obtener producto por ID
    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    // ✅ Buscar productos por estado (ej. A o I)
    @GetMapping("/state/{state}")
    public List<Product> findByState(@PathVariable Boolean state) {
        return productService.findByState(state);
    }

    // ✅ Buscar productos por nombre (texto parcial)
    @GetMapping("/search")
    public List<Product> searchByName(@RequestParam String name) {
        return productService.searchByName(name);
    }

    // Guardar un nuevo producto
    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    // Actualizar un producto existente
    @PutMapping("/update")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    // ✅ Eliminar producto (cambia estado a 'I')
    @PutMapping("/delete/{id}")
    public Product delete(@PathVariable Long id) {
        return productService.deleteById(id);
    }

    // ✅ Restaurar producto (cambia estado a 'A')
    @PutMapping("/restore/{id}")
    public Product restore(@PathVariable Long id) {
        return productService.restoreById(id);
    }
}
