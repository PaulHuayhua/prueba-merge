package pe.edu.vallegrande.inventaStore.rest;

import pe.edu.vallegrande.inventaStore.model.Supplier;
import pe.edu.vallegrande.inventaStore.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/supplier")
public class SupplierRest {

    private final SupplierService supplierService;

    @Autowired
    public SupplierRest(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    
    @GetMapping
    public List <Supplier> findAll(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Supplier> findById(@PathVariable Long id) {
        return supplierService.findById(id);
    }
    
    @GetMapping("/state/{state}")
    public List<Supplier> findByState(@PathVariable String state) {
        return supplierService.findByState(state);
    }

    @PostMapping("/save")
    public Supplier save(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @PutMapping("/update")
    public Supplier update(@RequestBody Supplier supplier) {
        return supplierService.update(supplier);
    }

    @PutMapping("/delete/{id}")
    public Optional<Supplier> softDelete(@PathVariable Long id) {
        return supplierService.softDelete(id);
    }

    @PutMapping("/restore/{id}")
    public Optional<Supplier> restore(@PathVariable Long id) {
        return supplierService.restore(id);
    }

}
