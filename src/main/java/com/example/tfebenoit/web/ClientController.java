package com.example.tfebenoit.web;

import com.example.tfebenoit.entity.Client;
import com.example.tfebenoit.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientRepo clientRepo;

    @GetMapping("/{productId}")
    public Client getProduct(@PathVariable int productId) {
        return clientRepo.findById(productId).orElseThrow();
    }

    @GetMapping
    public List<Client> getProduc() {
        return clientRepo.findAll();
    }

    @PostMapping
    public Client createProduct(@RequestBody Client product) {
        return clientRepo.save(product);
    }



}
