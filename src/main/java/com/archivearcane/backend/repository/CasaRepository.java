package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository responsável pelo acesso aos dados da entidade Casa.
 * Fornece operações CRUD e consultas personalizadas utilizando Spring Data JPA.
 */
public interface CasaRepository extends JpaRepository<Casa, Long> {

    /**
     * Busca casas pelo nome do fundador.
     *
     * @param fundador nome do fundador.
     * @return lista de casas encontradas.
     */
    List<Casa> findByFundador(String fundador);

    /**
     * Retorna as casas ordenadas pela pontuação em ordem decrescente.
     *
     * @return ranking das casas.
     */
    List<Casa> findAllByOrderByPontuacaoDesc();

}