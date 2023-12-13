package com.example.tfebenoit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClients;

    @Column(name = "Noms_Client")
    private String nomsClient;

    @Column(name = "Adresse_Client")
    private String adresseClient;

    @Column(name = "Numero_Client")
    private String numeroClient;

    @Column(name = "code_pin")
    private String codePin;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Compte> comptes;

}
