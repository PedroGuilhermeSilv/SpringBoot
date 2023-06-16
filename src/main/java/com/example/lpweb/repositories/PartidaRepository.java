package com.example.lpweb.repositories;

import com.example.lpweb.models.PartidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<PartidaModel,Integer> {
}
