package com.example.lpweb.repositories;

import com.example.lpweb.models.JogadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorModel, Integer> {
}
