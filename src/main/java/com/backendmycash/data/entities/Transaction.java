package com.backendmycash.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "transactions")
public class Transaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(precision = 10, scale = 2)
    private BigDecimal montant;

    private Integer destinataire;
    private Integer agent;
    private Integer exp;

    // Changez le nom de la propriété ici
    @Column(name = "type_id")
    private Integer typeId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "agent", insertable = false, updatable = false)
    private User agentUser;

    @ManyToOne
    @JoinColumn(name = "destinataire", insertable = false, updatable = false)
    private User destinataireUser;

    @ManyToOne
    @JoinColumn(name = "exp", insertable = false, updatable = false)
    private User expUser;

    @ManyToOne
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private Type type;
}
