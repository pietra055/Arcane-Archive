package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Combinacao;
import com.archivearcane.backend.model.Elemento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CombinacaoRepository extends JpaRepository<Combinacao, Long> {

    // Buscar combinações pelo elemento resultante
    List<Combinacao> findByResultado(Elemento resultado);

    // Buscar combinações pelo primeiro elemento
    List<Combinacao> findByElemento1(Elemento elemento1);

    // Buscar combinações pelo segundo elemento
    List<Combinacao> findByElemento2(Elemento elemento2);

    // Buscar uma combinação pelos dois elementos
    Optional<Combinacao> findByElemento1AndElemento2(Elemento elemento1,
                                                     Elemento elemento2);

}