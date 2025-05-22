package pe.edu.vallegrande.inventaStore.service.impl;

import pe.edu.vallegrande.inventaStore.model.Supplier;
import pe.edu.vallegrande.inventaStore.repository.SupplierRepository;
import pe.edu.vallegrande.inventaStore.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    

    @Override
    public List<Supplier> findAll() {
        log.info("Listando Datos: ");
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> findById(Long identifier) {
        log.info("Listando Datos por ID: ");
        return supplierRepository.findById(identifier);
    }

    @Override
    public List<Supplier> findByState(Boolean state) {
        log.info("Listando Datos por estado: ");
        return supplierRepository.findByState(state);
    }

    @Override
    public Supplier save(Supplier supplier) {
        log.info("Registrondo Datos: " + supplier.toString());
        supplier.setState(true);
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        log.info("Editando Datos: " + supplier.toString());
        supplier.setState(true);
        return supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> softDelete(Long identifier) {
        Optional<Supplier> supplierOpt = supplierRepository.findById(identifier);
        supplierOpt.ifPresent(supplier -> {
            supplier.setState(false);
            supplierRepository.save(supplier);
        });
        return supplierOpt;
    }

    @Override
    public Optional<Supplier> restore(Long identifier) {
        Optional<Supplier> supplierOpt = supplierRepository.findById(identifier);
        supplierOpt.ifPresent(supplier -> {
            supplier.setState(true);
            supplierRepository.save(supplier);
        });
        return supplierOpt;
    }

}