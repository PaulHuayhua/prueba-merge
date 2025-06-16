package pe.edu.vallegrande.inventaStore.rest;

import pe.edu.vallegrande.inventaStore.model.Customer;
import pe.edu.vallegrande.inventaStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/customer")
public class CustomerRest {

    private final CustomerService customerService;

    @Autowired
    public CustomerRest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{identifier}")
    public Optional<Customer> findById(@PathVariable Long identifier) {
        return customerService.findById(identifier);
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @PutMapping("/delete/{identifier}")
    public Optional<Customer> softDelete(@PathVariable Long identifier) {
        return customerService.softDelete(identifier);
    }

    @PutMapping("/restore/{identifier}")
    public Optional<Customer> restore(@PathVariable Long identifier) {
        return customerService.restore(identifier);
    }
}
