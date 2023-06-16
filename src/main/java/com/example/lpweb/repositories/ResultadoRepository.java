package com.example.lpweb.repositories;

import com.example.lpweb.models.ResultadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<ResultadoModel,Integer> {
}
