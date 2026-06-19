package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.CriaturaMagica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriaturaMagicaRepository extends JpaRepository<CriaturaMagica, Long> {

}