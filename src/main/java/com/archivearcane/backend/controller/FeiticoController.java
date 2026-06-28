package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.Elemento;
import com.archivearcane.backend.model.Feitico;
import com.archivearcane.backend.model.NivelDificuldade;
import com.archivearcane.backend.model.TipoFeitico;
import com.archivearcane.backend.service.FeiticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelo gerenciamento dos feitiços.
 * Disponibiliza os endpoints para operações de cadastro,
 * consulta, atualização, exclusão e consultas específicas.
 */
@RestController
@RequestMapping("/feiticos")
@CrossOrigin(origins = "*")
public class FeiticoController {

    @Autowired
    private FeiticoService service;

    // ===================== CRUD =====================

    /**
     * Lista todos os feitiços cadastrados.
     *
     * @return lista de feitiços.
     */
    @GetMapping
    public List<Feitico> listarTodos() {
        return service.listarTodos();
    }

    /**
     * Busca um feitiço pelo seu identificador.
     *
     * @param id identificador do feitiço.
     * @return feitiço encontrado.
     */
    @GetMapping("/{id}")
    public Feitico buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * Cadastra um novo feitiço.
     *
     * @param feitico objeto contendo os dados do feitiço.
     * @return feitiço cadastrado.
     */
    @PostMapping
    public Feitico salvar(@RequestBody Feitico feitico) {
        return service.salvar(feitico);
    }

    /**
     * Atualiza os dados de um feitiço existente.
     *
     * @param id identificador do feitiço.
     * @param feitico novos dados do feitiço.
     * @return feitiço atualizado.
     */
    @PutMapping("/{id}")
    public Feitico atualizar(@PathVariable Long id,
                             @RequestBody Feitico feitico) {
        return service.atualizar(id, feitico);
    }

    /**
     * Remove um feitiço cadastrado.
     *
     * @param id identificador do feitiço.
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // ===================== CONSULTAS =====================

    /**
     * Busca feitiços pelo elemento mágico.
     *
     * @param elemento elemento do feitiço.
     * @return lista de feitiços encontrados.
     */
    @GetMapping("/elemento/{elemento}")
    public List<Feitico> buscarPorElemento(@PathVariable Elemento elemento) {
        return service.buscarPorElemento(elemento);
    }

    /**
     * Busca feitiços pelo tipo.
     *
     * @param tipo tipo do feitiço.
     * @return lista de feitiços encontrados.
     */
    @GetMapping("/tipo/{tipo}")
    public List<Feitico> buscarPorTipo(@PathVariable TipoFeitico tipo) {
        return service.buscarPorTipo(tipo);
    }

    /**
     * Busca feitiços pelo nível de dificuldade.
     *
     * @param nivel nível de dificuldade do feitiço.
     * @return lista de feitiços encontrados.
     */
    @GetMapping("/dificuldade/{nivel}")
    public List<Feitico> buscarPorNivelDificuldade(@PathVariable NivelDificuldade nivel) {
        return service.buscarPorNivelDificuldade(nivel);
    }

}