package pe.edu.vallegrande.inventaStore.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier")
    private Long identifier;

    @Column(name = "issue_date", nullable = false)
    private LocalDateTime issue_date;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal total_price;

    @Column(name = "customer_identifier", nullable = false)
    private Long customer_identifier;

    @Column(name = "user_identifier", nullable = false)
    private Long user_identifier;
}
