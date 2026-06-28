package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Elemento;
import com.archivearcane.backend.model.Feitico;
import com.archivearcane.backend.model.NivelDificuldade;
import com.archivearcane.backend.model.TipoFeitico;
import com.archivearcane.backend.repository.FeiticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável pelas regras de negócio relacionadas aos feitiços.
 * Realiza operações de cadastro, consulta, atualização, exclusão
 * e consultas específicas sobre os feitiços do sistema.
 */
@Service
public class FeiticoService {

    @Autowired
    private FeiticoRepository repository;

    // ===================== CRUD =====================

    /**
     * Lista todos os feitiços cadastrados.
     *
     * @return lista de feitiços.
     */
    public List<Feitico> listarTodos() {
        return repository.findAll();
    }

    /**
     * Busca um feitiço pelo seu identificador.
     *
     * @param id identificador do feitiço.
     * @return feitiço encontrado.
     */
    public Feitico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Feitiço"));
    }

    /**
     * Cadastra um novo feitiço.
     *
     * @param feitico objeto contendo os dados do feitiço.
     * @return feitiço cadastrado.
     */
    public Feitico salvar(Feitico feitico) {
        return repository.save(feitico);
    }

    /**
     * Atualiza os dados de um feitiço existente.
     *
     * @param id identificador do feitiço.
     * @param feiticoAtualizado novos dados do feitiço.
     * @return feitiço atualizado.
     */
    public Feitico atualizar(Long id, Feitico feiticoAtualizado) {

        return repository.findById(id)
                .map(feitico -> {

                    feitico.setNome(feiticoAtualizado.getNome());
                    feitico.setElemento(feiticoAtualizado.getElemento());
                    feitico.setTipo(feiticoAtualizado.getTipo());
                    feitico.setDescricao(feiticoAtualizado.getDescricao());
                    feitico.setNivelDificuldade(feiticoAtualizado.getNivelDificuldade());

                    return repository.save(feitico);

                })
                .orElseThrow(() ->
                        new RuntimeException("Feitiço"));
    }

    /**
     * Remove um feitiço cadastrado.
     *
     * @param id identificador do feitiço.
     */
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ===================== CONSULTAS =====================

    /**
     * Busca feitiços pelo elemento mágico.
     *
     * @param elemento elemento do feitiço.
     * @return lista de feitiços encontrados.
     */
    public List<Feitico> buscarPorElemento(Elemento elemento) {
        return repository.findByElemento(elemento);
    }

    /**
     * Busca feitiços pelo tipo.
     *
     * @param tipo tipo do feitiço.
     * @return lista de feitiços encontrados.
     */
    public List<Feitico> buscarPorTipo(TipoFeitico tipo) {
        return repository.findByTipo(tipo);
    }

    /**
     * Busca feitiços pelo nível de dificuldade.
     *
     * @param nivelDificuldade nível de dificuldade do feitiço.
     * @return lista de feitiços encontrados.
     */
    public List<Feitico> buscarPorNivelDificuldade(NivelDificuldade nivelDificuldade) {
        return repository.findByNivelDificuldade(nivelDificuldade);
    }

}