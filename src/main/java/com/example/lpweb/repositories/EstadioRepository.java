package com.example.lpweb.repositories;

import com.example.lpweb.models.EstadioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadioRepository extends JpaRepository<EstadioModel,Integer> {
}
