package pe.edu.vallegrande.inventaStore.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "purchase")  // Coincide con tu tabla en la base de datos
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier")
    private Long identifier;

    @Column(name = "purchase_date", nullable = false)
    private LocalDateTime purchaseDate;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal total_price;

    @Column(name = "supplier_identifier", nullable = false)
    private Long supplier_identifier;

    @Column(name = "user_identifier", nullable = false)
    private Long user_identifier;

    @ElementCollection
    @CollectionTable(
        name = "purchase_detail",
        joinColumns = @JoinColumn(name = "purchase_identifier")
    )
    private List<Detail> details;

    @Embeddable
    @Data
    public static class Detail {

        @Column(name = "product_identifier", nullable = false)
        private Long product_identifier;

        @Column(name = "amount", nullable = false)
        private Integer amount;

        @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
        private BigDecimal subtotal;
    }

    @PrePersist
    public void prePersist() {
        if (purchaseDate == null) {
            purchaseDate = LocalDateTime.now();
        }
    }
}
