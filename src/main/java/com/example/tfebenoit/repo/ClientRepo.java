package com.example.tfebenoit.repo;

import com.example.tfebenoit.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "client")
public interface ClientRepo extends JpaRepository<Client, Integer> {
}
