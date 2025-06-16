package pe.edu.vallegrande.inventaStore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.inventaStore.model.Purchase;
import pe.edu.vallegrande.inventaStore.service.PurchaseService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/purchase")
public class PurchaseRest {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseRest(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<Purchase> findAll() {
        return purchaseService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Purchase> findById(@PathVariable Long id) {
        return purchaseService.findById(id);
    }

    @PostMapping
    public Purchase save(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    }

    @PutMapping("/{id}")
    public Purchase update(@PathVariable Long id, @RequestBody Purchase purchase) {
        purchase.setIdentifier(id); // Asegura que se actualice la entidad correcta
        return purchaseService.update(purchase);
    }

    @GetMapping("/count")
    public long countPurchases() {
        return purchaseService.countPurchases();
    }

}
