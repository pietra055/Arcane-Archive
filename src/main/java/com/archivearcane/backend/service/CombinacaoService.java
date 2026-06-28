package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Combinacao;
import com.archivearcane.backend.model.Elemento;
import com.archivearcane.backend.repository.CombinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável pelas regras de negócio relacionadas às combinações de
 * elementos mágicos. Realiza operações de cadastro, consulta, atualização,
 * exclusão e consultas específicas das combinações.
 */
@Service
public class CombinacaoService {

    @Autowired
    private CombinacaoRepository repository;

    // ===================== CRUD =====================

    /**
     * Lista todas as combinações cadastradas.
     *
     * @return lista de combinações.
     */
    public List<Combinacao> listarTodas() {
        return repository.findAll();
    }

    /**
     * Busca uma combinação pelo seu identificador.
     *
     * @param id identificador da combinação.
     * @return combinação encontrada.
     */
    public Combinacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Combinação"));
    }

    /**
     * Cadastra uma nova combinação de elementos.
     *
     * @param combinacao objeto contendo os dados da combinação.
     * @return combinação cadastrada.
     */
    public Combinacao salvar(Combinacao combinacao) {
        return repository.save(combinacao);
    }

    /**
     * Atualiza os dados de uma combinação existente.
     *
     * @param id identificador da combinação.
     * @param combinacaoAtualizada novos dados da combinação.
     * @return combinação atualizada.
     */
    public Combinacao atualizar(Long id, Combinacao combinacaoAtualizada) {

        return repository.findById(id)
                .map(combinacao -> {

                    combinacao.setElemento1(combinacaoAtualizada.getElemento1());
                    combinacao.setElemento2(combinacaoAtualizada.getElemento2());
                    combinacao.setResultado(combinacaoAtualizada.getResultado());
                    combinacao.setDescricao(combinacaoAtualizada.getDescricao());
                    combinacao.setNivelDificuldade(combinacaoAtualizada.getNivelDificuldade());

                    return repository.save(combinacao);

                })
                .orElseThrow(() ->
                        new RuntimeException("Combinação"));
    }

    /**
     * Remove uma combinação cadastrada.
     *
     * @param id identificador da combinação.
     */
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ===================== CONSULTAS =====================

    /**
     * Busca combinações pelo elemento resultante.
     *
     * @param resultado elemento resultante da combinação.
     * @return lista de combinações encontradas.
     */
    public List<Combinacao> buscarPorResultado(Elemento resultado) {
        return repository.findByResultado(resultado);
    }

    /**
     * Busca combinações pelo primeiro elemento.
     *
     * @param elemento1 primeiro elemento da combinação.
     * @return lista de combinações encontradas.
     */
    public List<Combinacao> buscarPorElemento1(Elemento elemento1) {
        return repository.findByElemento1(elemento1);
    }

    /**
     * Busca combinações pelo segundo elemento.
     *
     * @param elemento2 segundo elemento da combinação.
     * @return lista de combinações encontradas.
     */
    public List<Combinacao> buscarPorElemento2(Elemento elemento2) {
        return repository.findByElemento2(elemento2);
    }

    /**
     * Busca uma combinação utilizando os dois elementos informados.
     *
     * @param elemento1 primeiro elemento.
     * @param elemento2 segundo elemento.
     * @return combinação encontrada.
     */
    public Combinacao buscarPorElementos(Elemento elemento1, Elemento elemento2) {

        return repository.findByElemento1AndElemento2(elemento1, elemento2)
                .orElseThrow(() ->
                        new RuntimeException("Combinação"));
    }

}