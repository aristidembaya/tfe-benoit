package com.example.tfebenoit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "operations")
@Data
@AllArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperation;

    @Column(name = "Type_operation")
    private String typeOperation="Retrait";
    @Column(name = "montant")
    private Long montant;
    @Column(name = "Date_operation")
    @CreationTimestamp
    private Date dateOperation;

    @ManyToOne
    private Compte compte;

}