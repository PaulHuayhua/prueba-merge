package pe.edu.vallegrande.inventaStore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier")
    private Integer identifier;

    @Column(name = "name", length = 80, nullable = false)
    private String name;
}
