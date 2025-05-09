package pe.edu.vallegrande.inventaStore.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "identifier")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifier;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "flavor")
    private String flavor;

    @Column(name = "size")
    private String size;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "state")
    private String state;

    @Column(name = "category_identifier")
    private Long categoryIdentifier;
}
