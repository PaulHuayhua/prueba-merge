package pe.edu.vallegrande.inventaStore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.vallegrande.inventaStore.model.Product;
import pe.edu.vallegrande.inventaStore.model.Purchase;
import pe.edu.vallegrande.inventaStore.model.Sale;
import pe.edu.vallegrande.inventaStore.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/v1/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationRest {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/low-stock")
    public List<Product> getLowStock() {
        return notificationService.getLowStockProducts();
    }

    @GetMapping("/expiring")
    public List<Product> getExpiringSoon() {
        return notificationService.getExpiringProducts();
    }

    @GetMapping("/recent-sales")
    public List<Sale> getRecentSales() {
        return notificationService.getRecentSales();
    }

    @GetMapping("/recent-purchases")
    public List<Purchase> getRecentPurchases() {
        return notificationService.getRecentPurchases();
    }
}
