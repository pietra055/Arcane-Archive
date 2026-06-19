package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Bruxo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BruxoRepository extends JpaRepository<Bruxo, Long> {
}