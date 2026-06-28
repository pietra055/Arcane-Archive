package com.archivearcane.backend.repository;

import com.archivearcane.backend.model.Casa;
import com.archivearcane.backend.model.CriaturaMagica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository responsável pelo acesso aos dados da entidade CriaturaMagica.
 * Fornece operações CRUD e consultas personalizadas utilizando Spring Data JPA.
 */
public interface CriaturaMagicaRepository extends JpaRepository<CriaturaMagica, Long> {

    /**
     * Busca criaturas mágicas pela categoria.
     *
     * @param categoria categoria da criatura.
     * @return lista de criaturas encontradas.
     */
    List<CriaturaMagica> findByCategoria(String categoria);

    /**
     * Busca criaturas mágicas pelo nível de periculosidade.
     *
     * @param periculosidade nível de periculosidade.
     * @return lista de criaturas encontradas.
     */
    List<CriaturaMagica> findByPericulosidade(String periculosidade);

    /**
     * Busca criaturas mágicas pelo habitat.
     *
     * @param habitat habitat da criatura.
     * @return lista de criaturas encontradas.
     */
    List<CriaturaMagica> findByHabitat(String habitat);

    /**
     * Busca criaturas mágicas pertencentes a uma casa.
     *
     * @param casa casa associada.
     * @return lista de criaturas encontradas.
     */
    List<CriaturaMagica> findByCasa(Casa casa);

}