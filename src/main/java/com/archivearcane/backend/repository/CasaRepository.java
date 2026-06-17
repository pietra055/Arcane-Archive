package com.archivearcane.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.archivearcane.backend.model.Casa;

public interface CasaRepository extends JpaRepository<Casa, Long> {

}