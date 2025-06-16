package pe.edu.vallegrande.inventaStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.inventaStore.model.SaleDetail;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
    
}
