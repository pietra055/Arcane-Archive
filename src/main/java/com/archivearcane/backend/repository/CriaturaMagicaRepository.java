package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Casa;
import com.archivearcane.backend.model.CriaturaMagica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriaturaMagicaRepository extends JpaRepository<CriaturaMagica, Long> {

    List<CriaturaMagica> findByCategoria(String categoria);

    List<CriaturaMagica> findByPericulosidade(String periculosidade);

    List<CriaturaMagica> findByHabitat(String habitat);

    List<CriaturaMagica> findByCasa(Casa casa);

}