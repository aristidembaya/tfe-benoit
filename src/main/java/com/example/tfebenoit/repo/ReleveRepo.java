package com.example.tfebenoit.repo;

import com.example.tfebenoit.entity.ReleveDeComptes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "releve")
public interface ReleveRepo extends JpaRepository<ReleveDeComptes, Integer> {
}
