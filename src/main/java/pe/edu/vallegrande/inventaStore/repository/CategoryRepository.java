package pe.edu.vallegrande.inventaStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.inventaStore.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
