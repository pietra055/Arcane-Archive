package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.Combinacao;
import com.archivearcane.backend.model.Elemento;
import com.archivearcane.backend.service.CombinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelo gerenciamento das combinações de elementos.
 * Disponibiliza os endpoints para operações de cadastro,
 * consulta, atualização, exclusão e consultas específicas.
 */
@RestController
@RequestMapping("/combinacoes")
@CrossOrigin(origins = "*")
public class CombinacaoController {

    @Autowired
    private CombinacaoService service;

    // ===================== CRUD =====================

    /**
     * Lista todas as combinações cadastradas.
     *
     * @return lista de combinações.
     */
    @GetMapping
    public List<Combinacao> listarTodas() {
        return service.listarTodas();
    }

    /**
     * Busca uma combinação pelo seu identificador.
     *
     * @param id identificador da combinação.
     * @return combinação encontrada.
     */
    @GetMapping("/{id}")
    public Combinacao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * Cadastra uma nova combinação.
     *
     * @param combinacao objeto contendo os dados da combinação.
     * @return combinação cadastrada.
     */
    @PostMapping
    public Combinacao salvar(@RequestBody Combinacao combinacao) {
        return service.salvar(combinacao);
    }

    /**
     * Atualiza os dados de uma combinação existente.
     *
     * @param id identificador da combinação.
     * @param combinacao novos dados da combinação.
     * @return combinação atualizada.
     */
    @PutMapping("/{id}")
    public Combinacao atualizar(@PathVariable Long id,
                                @RequestBody Combinacao combinacao) {
        return service.atualizar(id, combinacao);
    }

    /**
     * Remove uma combinação cadastrada.
     *
     * @param id identificador da combinação.
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // ===================== CONSULTAS =====================

    /**
     * Busca combinações pelo elemento resultante.
     *
     * @param resultado elemento resultante da combinação.
     * @return lista de combinações encontradas.
     */
    @GetMapping("/resultado/{resultado}")
    public List<Combinacao> buscarPorResultado(@PathVariable Elemento resultado) {
        return service.buscarPorResultado(resultado);
    }

    /**
     * Busca combinações pelo primeiro elemento.
     *
     * @param elemento1 primeiro elemento da combinação.
     * @return lista de combinações encontradas.
     */
    @GetMapping("/elemento1/{elemento1}")
    public List<Combinacao> buscarPorElemento1(@PathVariable Elemento elemento1) {
        return service.buscarPorElemento1(elemento1);
    }

    /**
     * Busca combinações pelo segundo elemento.
     *
     * @param elemento2 segundo elemento da combinação.
     * @return lista de combinações encontradas.
     */
    @GetMapping("/elemento2/{elemento2}")
    public List<Combinacao> buscarPorElemento2(@PathVariable Elemento elemento2) {
        return service.buscarPorElemento2(elemento2);
    }

    /**
     * Busca uma combinação a partir de dois elementos.
     *
     * @param elemento1 primeiro elemento.
     * @param elemento2 segundo elemento.
     * @return combinação encontrada.
     */
    @GetMapping("/{elemento1}/{elemento2}")
    public Combinacao buscarPorElementos(@PathVariable Elemento elemento1,
                                         @PathVariable Elemento elemento2) {
        return service.buscarPorElementos(elemento1, elemento2);
    }

}