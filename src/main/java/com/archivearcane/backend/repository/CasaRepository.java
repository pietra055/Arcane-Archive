package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CasaRepository extends JpaRepository<Casa, Long> {

    List<Casa> findByFundador(String fundador);

    List<Casa> findAllByOrderByPontuacaoDesc();

}