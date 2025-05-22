package pe.edu.vallegrande.inventaStore.repository;

import pe.edu.vallegrande.inventaStore.model.BuysDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuysDetailRepository extends JpaRepository<BuysDetail, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
