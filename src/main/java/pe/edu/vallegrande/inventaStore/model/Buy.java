package pe.edu.vallegrande.inventaStore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "buys")
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier")
    private Long identifier;

    @Column(name = "buys_date", nullable = false)
    private LocalDateTime buys_date;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal total_price;

    @Column(name = "user_identifier", nullable = false)
    private Long user_identifier;

    @Column(name = "supplier_identifier", nullable = false)
    private Long supplier_identifier;
}
