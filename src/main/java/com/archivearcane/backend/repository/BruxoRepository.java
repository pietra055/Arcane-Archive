package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Bruxo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BruxoRepository extends JpaRepository<Bruxo, Long> {

    List<Bruxo> findByCasaId(Long casaId);
    List<Bruxo> findByAnoEscolar(Integer anoEscolar);
    List<Bruxo> findByNivelAprendizadoMagia(String nivelAprendizadoMagia);

}