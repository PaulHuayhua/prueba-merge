package pe.edu.vallegrande.inventaStore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifier;

    @Column(name = "first_name", nullable = false, length = 180)
    private String first_name;

    @Column(name = "last_name", nullable = false, length = 250)
    private String last_name;

}

