package com.agrogestor.crud.repositories;

import com.agrogestor.crud.model.Bovino;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BovinoRepository extends JpaRepository<Bovino,Integer> {
}
