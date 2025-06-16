package pe.edu.vallegrande.inventaStore.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier")
    private Long identifier;

    @Column(name = "name", nullable = false, length = 70)
    private String name;

    @Column(name = "description", nullable = false, length = 160)
    private String description;

    @Column(name = "size", length = 20)
    private String size;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "expiration_date")
    private LocalDate expiration_date;

    @Column(name = "state", nullable = false)
    private Boolean state = true;

    @Column(name = "category", nullable = false, length = 100)
    private String category;
}
