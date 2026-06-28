package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.Bruxo;
import com.archivearcane.backend.service.BruxoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelo gerenciamento dos bruxos.
 * Disponibiliza os endpoints para operações de cadastro,
 * consulta, atualização, exclusão e consultas específicas.
 */
@RestController
@RequestMapping("/bruxos")
@CrossOrigin(origins = "*")
public class BruxoController {

    @Autowired
    private BruxoService service;

    // ===================== CRUD =====================

    /**
     * Lista todos os bruxos cadastrados.
     *
     * @return lista de bruxos.
     */
    @GetMapping
    public List<Bruxo> listarTodos() {
        return service.listarTodos();
    }

    /**
     * Busca um bruxo pelo seu identificador.
     *
     * @param id identificador do bruxo.
     * @return bruxo encontrado.
     */
    @GetMapping("/{id}")
    public Bruxo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * Cadastra um novo bruxo.
     *
     * @param bruxo objeto contendo os dados do bruxo.
     * @return bruxo cadastrado.
     */
    @PostMapping
    public Bruxo salvar(@RequestBody Bruxo bruxo) {
        return service.salvar(bruxo);
    }

    /**
     * Atualiza os dados de um bruxo existente.
     *
     * @param id identificador do bruxo.
     * @param bruxo novos dados do bruxo.
     * @return bruxo atualizado.
     */
    @PutMapping("/{id}")
    public Bruxo atualizar(@PathVariable Long id,
                           @RequestBody Bruxo bruxo) {
        return service.atualizar(id, bruxo);
    }

    /**
     * Remove um bruxo cadastrado.
     *
     * @param id identificador do bruxo.
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // ===================== CONSULTAS =====================

    /**
     * Busca todos os bruxos pertencentes a uma casa.
     *
     * @param casaId identificador da casa.
     * @return lista de bruxos da casa.
     */
    @GetMapping("/casa/{casaId}")
    public List<Bruxo> buscarPorCasa(@PathVariable Long casaId) {
        return service.buscarPorCasa(casaId);
    }

    /**
     * Busca bruxos pelo ano escolar.
     *
     * @param anoEscolar ano escolar do bruxo.
     * @return lista de bruxos encontrados.
     */
    @GetMapping("/ano/{anoEscolar}")
    public List<Bruxo> buscarPorAnoEscolar(@PathVariable Integer anoEscolar) {
        return service.buscarPorAnoEscolar(anoEscolar);
    }

    /**
     * Busca bruxos pelo nível de aprendizado em magia.
     *
     * @param nivel nível de aprendizado.
     * @return lista de bruxos encontrados.
     */
    @GetMapping("/nivel/{nivel}")
    public List<Bruxo> buscarPorNivelAprendizado(@PathVariable String nivel) {
        return service.buscarPorNivelAprendizado(nivel);
    }

}