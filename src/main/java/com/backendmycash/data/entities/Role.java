package com.backendmycash.data.entities;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class Role extends BaseEntity  {
    @Column(length = 50)
    private String libelle;

    @Column(precision = 10, scale = 2)
    private BigDecimal plafond;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}