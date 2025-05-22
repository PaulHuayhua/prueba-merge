package pe.edu.vallegrande.inventaStore.repository;

import pe.edu.vallegrande.inventaStore.model.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {

}
