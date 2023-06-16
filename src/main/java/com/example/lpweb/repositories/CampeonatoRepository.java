package com.example.lpweb.repositories;

import com.example.lpweb.models.CampeonatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeonatoRepository extends JpaRepository<CampeonatoModel, Integer> {
}
