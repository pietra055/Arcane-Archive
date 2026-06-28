package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Elemento;
import com.archivearcane.backend.model.Feitico;
import com.archivearcane.backend.model.NivelDificuldade;
import com.archivearcane.backend.model.TipoFeitico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeiticoRepository extends JpaRepository<Feitico, Long> {

    List<Feitico> findByElemento(Elemento elemento);
    List<Feitico> findByTipo(TipoFeitico tipo);
    List<Feitico> findByNivelDificuldade(NivelDificuldade nivelDificuldade);

}