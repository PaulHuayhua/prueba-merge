package pe.edu.vallegrande.inventaStore.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.inventaStore.model.Purchase;
import pe.edu.vallegrande.inventaStore.repository.PurchaseRepository;
import pe.edu.vallegrande.inventaStore.service.PurchaseService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Optional<Purchase> findById(Long id) {
        return purchaseRepository.findById(id);
    }

    @Override
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase update(Purchase purchase) {
        if (purchase.getIdentifier() == null || !purchaseRepository.existsById(purchase.getIdentifier())) {
            throw new RuntimeException("Purchase with ID " + purchase.getIdentifier() + " does not exist");
        }
        return purchaseRepository.save(purchase);
    }

    @Override
    public long countPurchases() {
        return purchaseRepository.count();
    }

}
