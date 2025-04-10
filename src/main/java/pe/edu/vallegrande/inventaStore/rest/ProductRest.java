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


    // Obtener todos los productos
    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }


    // Buscar un producto por su ID
    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
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


    // Eliminar un producto
    @PutMapping("/delete")
    public Product delete(@RequestBody Product product) {
        return productService.delete(product);
    }
}
