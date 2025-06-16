package pe.edu.vallegrande.inventaStore.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.inventaStore.model.Sale;
import pe.edu.vallegrande.inventaStore.repository.SaleRepository;
import pe.edu.vallegrande.inventaStore.service.SaleService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public Optional<Sale> findById(Long identifier) {
        return saleRepository.findById(identifier);
    }

    @Override
    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Sale update(Sale sale) {
        if (sale.getIdentifier() == null || !saleRepository.existsById(sale.getIdentifier())) {
            throw new RuntimeException("Sale with identifier " + sale.getIdentifier() + " does not exist");
        }
        return saleRepository.save(sale);
    }

    @Override
    public BigDecimal getTotalSales() {
        return saleRepository.sumTotal();
    }

}
