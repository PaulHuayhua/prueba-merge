package pe.edu.vallegrande.inventaStore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.inventaStore.model.Customer;
import pe.edu.vallegrande.inventaStore.repository.CustomerRepository;
import pe.edu.vallegrande.inventaStore.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> softDelete(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(c -> {
            // Aquí podrías implementar borrado lógico si tienes un campo "state"
            // c.setState("INACTIVO");
            // customerRepository.save(c);
        });
        return customer;
    }

    @Override
    public Optional<Customer> restore(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(c -> {
            // c.setState("ACTIVO");
            // customerRepository.save(c);
        });
        return customer;
    }
}
