package com.example.lpweb.repositories;

import com.example.lpweb.models.TimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<TimeModel,Integer> {
}
