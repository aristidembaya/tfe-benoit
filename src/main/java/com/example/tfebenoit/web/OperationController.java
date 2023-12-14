package com.example.tfebenoit.web;

import com.example.tfebenoit.entity.Client;
import com.example.tfebenoit.entity.Compte;
import com.example.tfebenoit.entity.Operation;
import com.example.tfebenoit.repo.CompteRepo;
import com.example.tfebenoit.repo.OperationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/operations")
public class OperationController {
    @Autowired
    OperationRepo operationRepo;
    @Autowired
    CompteRepo compteRepo;

    @GetMapping("/{productId}")
    public Operation getProduct(@PathVariable int productId) {
        return operationRepo.findById(productId).orElseThrow();
    }

    @GetMapping
    public List<Operation> getProduc() {
        return operationRepo.findAll();
    }

    @PostMapping
    public Operation createProduct(@RequestBody Operation product) {
        return operationRepo.save(product);
    }
    @PostMapping("/{id}")
    public String retrait(@RequestParam("code") String code,@RequestParam("montant") Long montant, @PathVariable int id) {
        Compte compte=compteRepo.findById(id).orElseThrow();
        if(Objects.equals(compte.getCodePin(), code)){
            Operation op=new Operation();
            op.setCompte(compte);
            op.setTypeOperation("Retrait");
            op.setMontant(montant);
            operationRepo.save(op);
            compte.setSolde(compte.getSolde()-op.getMontant());
            compteRepo.save(compte);
            return "Success";
        }else {
            return "Failed";
        }

    }
}
