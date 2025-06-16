package pe.edu.vallegrande.inventaStore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "sale_detail")
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier")
    private Long identifier;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "product_identifier", nullable = false)
    private Long product_identifier;

    @ManyToOne
    @JoinColumn(name = "sale_identifier") 
    private Sale sale;

}
