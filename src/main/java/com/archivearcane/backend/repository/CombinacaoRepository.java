package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Combinacao;
import com.archivearcane.backend.model.Elemento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository responsável pelo acesso aos dados da entidade Combinacao.
 * Fornece operações CRUD e consultas personalizadas utilizando Spring Data JPA.
 */
public interface CombinacaoRepository extends JpaRepository<Combinacao, Long> {

    /**
     * Busca combinações pelo elemento resultante.
     *
     * @param resultado elemento resultante.
     * @return lista de combinações encontradas.
     */
    List<Combinacao> findByResultado(Elemento resultado);

    /**
     * Busca combinações pelo primeiro elemento.
     *
     * @param elemento1 primeiro elemento.
     * @return lista de combinações encontradas.
     */
    List<Combinacao> findByElemento1(Elemento elemento1);

    /**
     * Busca combinações pelo segundo elemento.
     *
     * @param elemento2 segundo elemento.
     * @return lista de combinações encontradas.
     */
    List<Combinacao> findByElemento2(Elemento elemento2);

    /**
     * Busca uma combinação pelos dois elementos informados.
     *
     * @param elemento1 primeiro elemento.
     * @param elemento2 segundo elemento.
     * @return combinação encontrada, se existir.
     */
    Optional<Combinacao> findByElemento1AndElemento2(Elemento elemento1,
                                                     Elemento elemento2);

}