package com.backendmycash.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 20, unique = true)
    private String telephone;

    @Column(length = 100, unique = true)
    private String email;

    @Column(precision = 10, scale = 2)
    private BigDecimal solde;

    @Column(length = 50)
    private String code;

    @Column(precision = 5, scale = 2)
    private BigDecimal promo;

    private String carte;
    private Boolean etatcarte;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "agentUser")
    private List<Transaction> transactionsAsAgent;

    @OneToMany(mappedBy = "destinataireUser")
    private List<Transaction> transactionsAsDestinataire;

    @OneToMany(mappedBy = "expUser")
    private List<Transaction> transactionsAsExp;
}
