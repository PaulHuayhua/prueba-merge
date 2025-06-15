package pe.edu.vallegrande.inventaStore.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier")
    private Long identifier;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String password_hash;

    @Column(name = "rol", nullable = false, length = 60)
    private String rol;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registration_date;

    @Column(name = "state", nullable = false, length = 1)
    private String state = "A";

    @PrePersist
    public void prePersist() {
        if (registration_date == null) {
            registration_date = LocalDate.now();
        }
    }

}
