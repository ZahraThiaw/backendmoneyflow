package com.backendmycash.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "types")
public class Type extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String libelle;

    @OneToMany(mappedBy = "type")
    private List<Transaction> transactions;

}
