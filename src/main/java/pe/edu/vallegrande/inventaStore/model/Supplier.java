package pe.edu.vallegrande.inventaStore.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "supplier")
public class Supplier {

    @Id
    @Column(name = "identifier")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifier;

    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

    @Column(name = "supply_type")
    private String supply_type;

    @Column(name = "address")
    private String address;

    @Column(name = "email_business")
    private String email_business;

    @Column(name = "cell_phone")
    private String cell_phone;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "state")
    private Boolean state = true;

    @Column(name = "registration_date")
    private LocalDate registration_date;
}
