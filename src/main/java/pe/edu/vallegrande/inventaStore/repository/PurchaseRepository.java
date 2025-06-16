package pe.edu.vallegrande.inventaStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.inventaStore.model.Purchase;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    long count();

    List<Purchase> findTop5ByOrderByPurchaseDateDesc();

}
