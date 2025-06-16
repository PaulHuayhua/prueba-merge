package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    List<Purchase> findAll();
    Optional<Purchase> findById(Long id);
    Purchase save(Purchase purchase);
    Purchase update(Purchase purchase);
    long countPurchases();
}
