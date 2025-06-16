package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.Product;
import pe.edu.vallegrande.inventaStore.model.Purchase;
import pe.edu.vallegrande.inventaStore.model.Sale;

import java.util.List;

public interface NotificationService {
    List<Product> getLowStockProducts();
    List<Product> getExpiringProducts();
    List<Sale> getRecentSales();
    List<Purchase> getRecentPurchases();
}
