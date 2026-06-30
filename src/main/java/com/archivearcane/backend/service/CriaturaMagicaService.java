package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Casa;
import com.archivearcane.backend.model.CriaturaMagica;
import com.archivearcane.backend.repository.CasaRepository;
import com.archivearcane.backend.repository.CriaturaMagicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável pelas regras de negócio relacionadas às criaturas mágicas.
 * Realiza operações de cadastro, consulta, atualização, exclusão
 * e consultas específicas sobre as criaturas do sistema.
 */
@Service
public class CriaturaMagicaService {

    @Autowired
    private CriaturaMagicaRepository repository;

    @Autowired
    private CasaRepository casaRepository;

    // ================= CRUD =================

    /**
     * Lista todas as criaturas mágicas cadastradas.
     *
     * @return lista de criaturas mágicas.
     */
    public List<CriaturaMagica> listarTodas() {
        return repository.findAll();
    }

    /**
     * Busca uma criatura mágica pelo seu identificador.
     *
     * @param id identificador da criatura.
     * @return criatura encontrada.
     */
    public CriaturaMagica buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Criatura"));
    }

    /**
     * Cadastra uma nova criatura mágica.
     *
     * @param criatura objeto contendo os dados da criatura.
     * @return criatura cadastrada.
     */
    public CriaturaMagica salvar(CriaturaMagica criatura) {

        if (criatura.getCasa() != null) {

            Casa casa = casaRepository.findById(criatura.getCasa().getId())
                    .orElseThrow(() ->
                            new RuntimeException("Casa"));

            criatura.setCasa(casa);
        }

        return repository.save(criatura);
    }

    /**
     * Atualiza os dados de uma criatura mágica existente.
     *
     * @param id identificador da criatura.
     * @param criaturaAtualizada novos dados da criatura.
     * @return criatura atualizada.
     */
    public CriaturaMagica atualizar(Long id, CriaturaMagica criaturaAtualizada) {

        return repository.findById(id)
                .map(criatura -> {

                    criatura.setNome(criaturaAtualizada.getNome());
                    criatura.setCategoria(criaturaAtualizada.getCategoria());
                    criatura.setPericulosidade(criaturaAtualizada.getPericulosidade());
                    criatura.setHabitat(criaturaAtualizada.getHabitat());

                    if (criaturaAtualizada.getCasa() != null) {

                        Casa casa = casaRepository.findById(
                                criaturaAtualizada.getCasa().getId())
                                .orElseThrow(() ->
                                        new RuntimeException("Casa"));

                        criatura.setCasa(casa);
                    } else {
                        criatura.setCasa(null);
                    }

                    return repository.save(criatura);

                })
                .orElseThrow(() ->
                        new RuntimeException("Criatura"));
    }

    /**
     * Remove uma criatura mágica cadastrada.
     *
     * @param id identificador da criatura.
     */
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ================= CONSULTAS =================

    /**
     * Busca criaturas mágicas pela categoria.
     *
     * @param categoria categoria da criatura.
     * @return lista de criaturas encontradas.
     */
    public List<CriaturaMagica> buscarPorCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    /**
     * Busca criaturas mágicas pelo nível de periculosidade.
     *
     * @param periculosidade nível de periculosidade da criatura.
     * @return lista de criaturas encontradas.
     */
    public List<CriaturaMagica> buscarPorPericulosidade(String periculosidade) {
        return repository.findByPericulosidade(periculosidade);
    }

    /**
     * Busca criaturas mágicas pelo habitat.
     *
     * @param habitat habitat da criatura.
     * @return lista de criaturas encontradas.
     */
    public List<CriaturaMagica> buscarPorHabitat(String habitat) {
        return repository.findByHabitat(habitat);
    }

    /**
     * Busca todas as criaturas pertencentes a uma casa.
     *
     * @param idCasa identificador da casa.
     * @return lista de criaturas da casa.
     */
    public List<CriaturaMagica> buscarPorCasa(Long idCasa) {

        Casa casa = casaRepository.findById(idCasa)
                .orElseThrow(() ->
                        new RuntimeException("Casa"));

        return repository.findByCasa(casa);
    }

}