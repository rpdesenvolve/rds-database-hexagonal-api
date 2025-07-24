package br.com.rpdesenvolve.rds_database_hexagonal_api.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public User (String name, String email) {
        this.name = name;
        this.email = email;
    }
}
