package pe.edu.vallegrande.inventaStore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.inventaStore.model.Product;
import pe.edu.vallegrande.inventaStore.model.Purchase;
import pe.edu.vallegrande.inventaStore.model.Sale;
import pe.edu.vallegrande.inventaStore.repository.ProductRepository;
import pe.edu.vallegrande.inventaStore.repository.PurchaseRepository;
import pe.edu.vallegrande.inventaStore.repository.SaleRepository;
import pe.edu.vallegrande.inventaStore.service.NotificationService;

import java.util.List;


    @Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired private ProductRepository productRepository;
    @Autowired private SaleRepository saleRepository;
    @Autowired private PurchaseRepository purchaseRepository;

    @Override
    public List<Product> getLowStockProducts() {
        return productRepository.findLowStockProducts();
    }

    @Override
    public List<Product> getExpiringProducts() {
        return productRepository.findExpiringSoonProducts();
    }

    @Override
    public List<Sale> getRecentSales() {
        return saleRepository.findTop5ByOrderByIssueDateDesc();
    }

    @Override
    public List<Purchase> getRecentPurchases() {
        return purchaseRepository.findTop5ByOrderByPurchaseDateDesc();
    }
}

