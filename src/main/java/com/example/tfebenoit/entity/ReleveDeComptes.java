package com.example.tfebenoit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "relevé_de_comptes")
@Data
@AllArgsConstructor
public class ReleveDeComptes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelevéDeComptes;

    @Column(name = "Date_de_début", nullable = false)
    private Date dateDeDébut;

    @Column(name = "Date_de_fin", nullable = false)
    private Date dateDeFin;


    // ... other methods as needed

}