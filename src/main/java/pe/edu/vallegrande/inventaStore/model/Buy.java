package pe.edu.vallegrande.inventaStore.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@Table(name = "buys")
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier")
    private Long identifier;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "buys_date", nullable = false)
    private LocalDateTime buys_date;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal total_price;

    @Column(name = "payment_method", nullable = false)
    private String payment_method;

    @Column(name = "user_identifier", nullable = false)
    private Long user_identifier;

    @Column(name = "supplier_identifier", nullable = false)
    private Long supplier_identifier;

    @ElementCollection
    @CollectionTable(
        name = "buys_detail",
        joinColumns = @JoinColumn(name = "buys_identifier")
    )
    private List<Detail> details;

    @Embeddable
    @Data
    public static class Detail {

        @Column(name = "product_identifier", nullable = false)
        private Long product_identifier;

        @Column(name = "amount", nullable = false)
        private Integer amount;

        @Column(name = "unit_cost", nullable = false, precision = 10, scale = 2)
        private BigDecimal unitCost;

        @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
        private BigDecimal subtotal;
    }

    @PrePersist
    public void prePersist() {
        if (buys_date == null) {
            buys_date = LocalDateTime.now();
        }
    }
}