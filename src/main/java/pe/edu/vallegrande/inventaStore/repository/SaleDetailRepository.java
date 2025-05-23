package pe.edu.vallegrande.inventaStore.repository;

import pe.edu.vallegrande.inventaStore.model.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {

}
