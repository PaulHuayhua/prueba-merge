package pe.edu.vallegrande.inventaStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.inventaStore.model.Sale;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT COALESCE(SUM(s.total_price), 0) FROM Sale s")
    BigDecimal sumTotal();

    List<Sale> findTop5ByOrderByIssueDateDesc();

}
