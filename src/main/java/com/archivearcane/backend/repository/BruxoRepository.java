package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Bruxo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository responsável pelo acesso aos dados da entidade Bruxo.
 * Fornece operações CRUD e consultas personalizadas utilizando Spring Data JPA.
 */
@Repository
public interface BruxoRepository extends JpaRepository<Bruxo, Long> {

    /**
     * Busca todos os bruxos pertencentes a uma casa.
     *
     * @param casaId identificador da casa.
     * @return lista de bruxos encontrados.
     */
    List<Bruxo> findByCasaId(Long casaId);

    /**
     * Busca bruxos pelo ano escolar.
     *
     * @param anoEscolar ano escolar do bruxo.
     * @return lista de bruxos encontrados.
     */
    List<Bruxo> findByAnoEscolar(Integer anoEscolar);

    /**
     * Busca bruxos pelo nível de aprendizado em magia.
     *
     * @param nivelAprendizadoMagia nível de aprendizado.
     * @return lista de bruxos encontrados.
     */
    List<Bruxo> findByNivelAprendizadoMagia(String nivelAprendizadoMagia);

}