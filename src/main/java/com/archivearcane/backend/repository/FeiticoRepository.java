package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Elemento;
import com.archivearcane.backend.model.Feitico;
import com.archivearcane.backend.model.NivelDificuldade;
import com.archivearcane.backend.model.TipoFeitico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository responsável pelo acesso aos dados da entidade Feitico.
 * Fornece operações CRUD e consultas personalizadas utilizando Spring Data JPA.
 */
public interface FeiticoRepository extends JpaRepository<Feitico, Long> {

    /**
     * Busca feitiços pelo elemento mágico.
     *
     * @param elemento elemento do feitiço.
     * @return lista de feitiços encontrados.
     */
    List<Feitico> findByElemento(Elemento elemento);

    /**
     * Busca feitiços pelo tipo.
     *
     * @param tipo tipo do feitiço.
     * @return lista de feitiços encontrados.
     */
    List<Feitico> findByTipo(TipoFeitico tipo);

    /**
     * Busca feitiços pelo nível de dificuldade.
     *
     * @param nivelDificuldade nível de dificuldade.
     * @return lista de feitiços encontrados.
     */
    List<Feitico> findByNivelDificuldade(NivelDificuldade nivelDificuldade);

}