package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.Sale;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

public interface SaleService {
    List<Sale> findAll();
    Optional<Sale> findById(Long identifier);
    Sale save(Sale sale);
    Sale update(Sale sale);
    BigDecimal getTotalSales();
}
