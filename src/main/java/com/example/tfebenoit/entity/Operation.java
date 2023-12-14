package com.example.tfebenoit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Entity
@Table(name = "operations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperation;
    @Value("Retrait")
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