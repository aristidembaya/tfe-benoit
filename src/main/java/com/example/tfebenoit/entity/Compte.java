package com.example.tfebenoit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "comptes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Solde_Compte", nullable = false)
    private Long solde; // tinyint(1) maps to byte in Java

    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "compte",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Operation> operations;


}