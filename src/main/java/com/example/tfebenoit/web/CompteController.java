package com.example.tfebenoit.web;

import com.example.tfebenoit.entity.Client;
import com.example.tfebenoit.entity.Compte;
import com.example.tfebenoit.repo.ClientRepo;
import com.example.tfebenoit.repo.CompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/comptes")
public class CompteController {
    @Autowired
    CompteRepo compteRepo;
    @Autowired
    ClientRepo clientRepo;

    @GetMapping("/{productId}")
    public Compte getProduct(@PathVariable int productId) {
        return compteRepo.findById(productId).orElseThrow();
    }

    @GetMapping
    public List<Compte> getProduc() {
        return compteRepo.findAll();
    }

    @PostMapping("/{id}")
    public Compte createProduct(@PathVariable int id,@RequestBody Compte product) {
        Client client=clientRepo.findById(id).orElseThrow();
        product.setClient(client);
        return compteRepo.save(product);
    }
}
